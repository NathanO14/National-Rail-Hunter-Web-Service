package com.nathanodong.nationaltrainhunterws.controller;

import com.nathanodong.nationaltrainhunterws.model.ServiceDeparture;
import com.nathanodong.nationaltrainhunterws.model.ServiceInformation;
import com.nathanodong.nationaltrainhunterws.service.ServiceDataService;
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
import java.util.List;

@RestController
@RequestMapping("v1")
public class ServiceDataController {

    @Autowired
    private ServiceDataService serviceDataService;

    @Autowired
    private ObjectFactory objectFactory;

    @RequestMapping(value = "/service/departureBoard", method = RequestMethod.GET)
    public List<ServiceDeparture> getDepartureBoardByCrs(@RequestParam int numRows,
                                                         @RequestParam String crs,
                                                         @RequestParam(required = false) String filterCrs,
                                                         @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime time,
                                                         @RequestParam int timeWindow) throws DatatypeConfigurationException {
        GetBoardByCRSParams boardByCRSParams = objectFactory.createGetBoardByCRSParams();
        boardByCRSParams.setNumRows(numRows);
        boardByCRSParams.setCrs(crs);
        boardByCRSParams.setFiltercrs(objectFactory.createGetBoardByCRSParamsFiltercrs(filterCrs));

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
