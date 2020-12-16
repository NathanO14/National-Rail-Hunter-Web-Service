package com.nathanodong.nationaltrainhunterws.controller;

import com.nathanodong.nationaltrainhunterws.model.ServiceDepartureResult;
import com.nathanodong.nationaltrainhunterws.model.ServiceInformation;
import com.nathanodong.nationaltrainhunterws.service.ServiceDataService;
import com.thalesgroup.rtti._2007_10_10.ldb.commontypes.FilterType;
import com.thalesgroup.rtti._2017_10_01.ldbsv.GetBoardByCRSParams;
import com.thalesgroup.rtti._2017_10_01.ldbsv.GetServiceDetailsByRIDParams;
import com.thalesgroup.rtti._2017_10_01.ldbsv.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.GregorianCalendar;

@RestController
@RequestMapping("v1")
public class ServiceDataController {

    private final ServiceDataService serviceDataService;

    private final ObjectFactory objectFactory;

    @Autowired
    public ServiceDataController(ServiceDataService serviceDataService, ObjectFactory objectFactory) {
        this.serviceDataService = serviceDataService;
        this.objectFactory = objectFactory;
    }

    @RequestMapping(value = "/service/departureBoard", method = RequestMethod.GET)
    public ServiceDepartureResult getDepartureBoardByCrs(@RequestParam int numRows,
                                                         @RequestParam String crs,
                                                         @RequestParam(required = false) String filterCrs,
                                                         @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime time,
                                                         @RequestParam int timeWindow,
                                                         @RequestParam FilterType filterType) throws DatatypeConfigurationException {
        GetBoardByCRSParams boardByCRSParams = objectFactory.createGetBoardByCRSParams();
        boardByCRSParams.setNumRows(numRows);
        boardByCRSParams.setCrs(crs);
        boardByCRSParams.setFiltercrs(objectFactory.createGetBoardByCRSParamsFiltercrs(filterCrs));
        boardByCRSParams.setFilterType(filterType);

        GregorianCalendar gcal = GregorianCalendar.from(time.atZone(ZoneId.systemDefault()));
        XMLGregorianCalendar xcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
        boardByCRSParams.setTime(xcal);

        boardByCRSParams.setTimeWindow(timeWindow);

        return serviceDataService.getDepartureBoard(boardByCRSParams);
    }

    @RequestMapping(value = "/service/details", method = RequestMethod.GET)
    public ServiceInformation getServiceDetails(@RequestParam String rid) {
        GetServiceDetailsByRIDParams serviceDetailsByRIDParams = new GetServiceDetailsByRIDParams();
        serviceDetailsByRIDParams.setRid(rid);

        return serviceDataService.getServiceDetails(serviceDetailsByRIDParams);
    }
}
