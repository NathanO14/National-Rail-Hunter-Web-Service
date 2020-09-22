package com.nathanodong.nationaltrainhunterws.service;

import com.nathanodong.nationaltrainhunterws.AbstractNTHIntegrationTest;
import com.thalesgroup.rtti._2017_10_01.ldbsv.ObjectFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ServiceDataServiceTest extends AbstractNTHIntegrationTest {

    @Autowired
    private ServiceDataService serviceDataService;

    @Autowired
    private ObjectFactory objectFactory;

    @Test
    void getDepartureBoard() throws Exception {
        //TODO: Complete
//        mockWebResponse("xml/GetDepartureBoardResponse.xml", 200);
//
//        GetBoardByCRSParams params = new GetBoardByCRSParams();
//        params.setCrs("STP");
////        params.setFilterCrs("CST");
////        params.setFilterType(FilterType.TO);
//
//        GetBoardByCRSParams boardByCRSParams = objectFactory.createGetBoardByCRSParams();
//        boardByCRSParams.setNumRows(1);
//        boardByCRSParams.setCrs("STP");
////        boardByCRSParams.setFiltercrs(objectFactory.createGetBoardByCRSParamsFiltercrs(""));
//
//        GregorianCalendar gcal = GregorianCalendar.from(LocalDateTime.now().atZone(ZoneId.systemDefault()));
//        XMLGregorianCalendar xcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
//        boardByCRSParams.setTime(xcal);
//
//        boardByCRSParams.setTimeWindow(60);
//
//        List<ServiceDeparture> serviceDepartures = serviceDataService.getDepartureBoard(params);
//
//        assertFalse(serviceDepartures.isEmpty());
    }
}