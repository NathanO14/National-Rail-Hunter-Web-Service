package com.nathanodong.nationaltrainhunterws.service;

import com.nathanodong.nationaltrainhunterws.model.ServiceDeparture;
import com.nathanodong.nationaltrainhunterws.model.ServiceInformation;
import com.thalesgroup.rtti._2013_11_28.token.types.AccessToken;
import com.thalesgroup.rtti._2017_10_01.ldb.*;
import com.thalesgroup.rtti._2017_10_01.ldb.types.ServiceDetails;
import com.thalesgroup.rtti._2017_10_01.ldb.types.ServiceItem;
import com.thalesgroup.rtti._2017_10_01.ldb.types.ServiceItemWithCallingPoints;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ServiceDataService {

    private final String ON_TIME = "On time";
    private final String CANCELLED = "Cancelled";

    @Autowired
    private AccessToken accessToken;

    @Autowired
    private LDBServiceSoap ldbServiceSoap;

    private final Logger logger = LoggerFactory.getLogger(ServiceDataService.class);

    public List<ServiceDeparture> getDepartureBoard(GetBoardRequestParams getBoardRequestParams) {
        List<ServiceDeparture> departures = new ArrayList<>();

        StationBoardWithDetailsResponseType departureBoard = ldbServiceSoap.getDepBoardWithDetails(getBoardRequestParams, accessToken);

        logger.debug("Trains at {}", departureBoard.getGetStationBoardResult().getLocationName());
        logger.debug("===============================================================================");

        List<ServiceItemWithCallingPoints> serviceItems = departureBoard.getGetStationBoardResult().getTrainServices() != null
                ? departureBoard.getGetStationBoardResult().getTrainServices().getService()
                : Collections.emptyList();

        for (ServiceItemWithCallingPoints serviceItem : serviceItems) {
            logger.debug("{}", serviceItem.toString());

            ServiceDeparture serviceDeparture = new ServiceDeparture();
            serviceDeparture.setRsId(serviceItem.getRsid());
            serviceDeparture.setServiceID(serviceItem.getServiceID());
            serviceDeparture.setPlatform(serviceItem.getPlatform());

            if (serviceItem.getOrigin().getLocation().size() > 1) {
                logger.info("ServiceInformation has multiple origins.");
            }
            serviceDeparture.setOriginStation(serviceItem.getOrigin().getLocation().get(0).getLocationName());


            // TODO: Handle case when train splits at a station
            if (serviceItem.getDestination().getLocation().size() > 1) {
                logger.debug("ServiceInformation has multiple destinations.");
            }
            serviceDeparture.setDestinationStation(serviceItem.getDestination().getLocation().get(0).getLocationName());
            serviceDeparture.setVia(serviceItem.getDestination().getLocation().get(0).getVia());

            serviceDeparture.setScheduledDepartureTime(convertToLocalDateTime(serviceItem.getStd()));
            serviceDeparture.setEstimatedDepartureTime(getEstimatedDepartureTime(serviceItem));
            serviceDeparture.setDelayed(!ON_TIME.equals(serviceItem.getEtd()));
            serviceDeparture.setCancelled(CANCELLED.equals(serviceItem.getEtd()));

            departures.add(serviceDeparture);
        }

        return departures;
    }

    public ServiceInformation getServiceDetails(GetServiceDetailsRequestParams getServiceDetailsRequestParams) {
        ServiceInformation serviceInformation = new ServiceInformation();

        ServiceDetailsResponseType serviceDetailsResponseType =
                ldbServiceSoap.getServiceDetails(getServiceDetailsRequestParams, accessToken);

        ServiceDetails serviceDetails = serviceDetailsResponseType.getGetServiceDetailsResult();
        logger.debug("{} - {}", serviceDetails.getRsid(), serviceDetails.getServiceType().value());

        serviceInformation.setRsId(serviceDetails.getRsid());
        serviceInformation.setNumberOfCoaches(serviceDetails.getLength());
        serviceInformation.setOperator(serviceDetails.getOperator());
        serviceInformation.setServiceType(serviceDetails.getServiceType());
        serviceInformation.setDelayReason(serviceDetails.getDelayReason());
        serviceInformation.setCancelled(serviceDetails.isIsCancelled());

        return serviceInformation;
    }

    private LocalTime getEstimatedDepartureTime(ServiceItem serviceItem) {
        if (ON_TIME.equals(serviceItem.getEtd())) {
            return convertToLocalDateTime(serviceItem.getStd());
        } else if (CANCELLED.equals(serviceItem.getEtd())) {
            return null;
        } else {
            return convertToLocalDateTime(serviceItem.getEtd());
        }
    }

    private LocalTime convertToLocalDateTime(String time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return LocalTime.parse(time, formatter);
    }
}
