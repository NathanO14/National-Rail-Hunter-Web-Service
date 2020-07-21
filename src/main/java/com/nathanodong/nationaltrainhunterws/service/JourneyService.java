package com.nathanodong.nationaltrainhunterws.service;

import com.nathanodong.nationaltrainhunterws.model.Journey;
import com.thalesgroup.rtti._2013_11_28.token.types.AccessToken;
import com.thalesgroup.rtti._2017_10_01.ldb.GetBoardRequestParams;
import com.thalesgroup.rtti._2017_10_01.ldb.LDBServiceSoap;
import com.thalesgroup.rtti._2017_10_01.ldb.StationBoardResponseType;
import com.thalesgroup.rtti._2017_10_01.ldb.types.ServiceItem;
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
public class JourneyService {

    private final String ON_TIME = "On time";

    @Autowired
    private AccessToken accessToken;

    @Autowired
    private LDBServiceSoap ldbServiceSoap;

    private final Logger logger = LoggerFactory.getLogger(JourneyService.class);

    public List<Journey> getDepartureBoard(GetBoardRequestParams getBoardRequestParams) {
        List<Journey> departures = new ArrayList<>();

        StationBoardResponseType departureBoard = ldbServiceSoap.getDepartureBoard(getBoardRequestParams, accessToken);

        logger.info("Trains at {}", departureBoard.getGetStationBoardResult().getLocationName());
        logger.info("===============================================================================");

        List<ServiceItem> serviceItems = departureBoard.getGetStationBoardResult().getTrainServices() != null
                ? departureBoard.getGetStationBoardResult().getTrainServices().getService()
                : Collections.emptyList();

        for (ServiceItem serviceItem : serviceItems) {
            logger.info("{} to {} - {}",
                    serviceItem.getStd(),
                    serviceItem.getDestination().getLocation().get(0).getLocationName(),
                    serviceItem.getEtd());

            Journey journey = new Journey();
            journey.setRsId(serviceItem.getRsid());
            journey.setServiceID(serviceItem.getServiceID());
            journey.setPlatform(serviceItem.getPlatform());

            if (serviceItem.getOrigin().getLocation().size() > 1) {
                logger.info("Service has multiple origins.");
            }
            journey.setOriginStation(serviceItem.getOrigin().getLocation().get(0).getLocationName());


            if (serviceItem.getDestination().getLocation().size() > 1) {
                logger.info("Service has multiple destinations.");
            }
            journey.setDestinationStation(serviceItem.getDestination().getLocation().get(0).getLocationName());

            journey.setScheduledDepartureTime(serviceItem.getStd());
            journey.setEstimatedDepartureTime(serviceItem.getEtd());

            departures.add(journey);
        }

        return departures;
    }
}
