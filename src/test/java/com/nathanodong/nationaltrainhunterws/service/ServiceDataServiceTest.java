package com.nathanodong.nationaltrainhunterws.service;

import com.nathanodong.nationaltrainhunterws.AbstractNTHIntegrationTest;
import com.thalesgroup.rtti._2017_10_01.ldbsv.GetBoardByCRSParams;
import com.thalesgroup.rtti._2017_10_01.ldbsv.ObjectFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.GregorianCalendar;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceDataServiceTest extends AbstractNTHIntegrationTest {

    @Autowired
    private ServiceDataService serviceDataService;

    @Autowired
    private ObjectFactory objectFactory;

    @Test
    public void getDepartureBoard() throws Exception {
        GetBoardByCRSParams boardByCRSParams = objectFactory.createGetBoardByCRSParams();
        boardByCRSParams.setNumRows(1);
        boardByCRSParams.setCrs("STP");

        GregorianCalendar gcal = GregorianCalendar.from(LocalDateTime.now().atZone(ZoneId.systemDefault()));
        XMLGregorianCalendar xcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
        boardByCRSParams.setTime(xcal);

        boardByCRSParams.setTimeWindow(60);

//        when(ldbsvServiceSoap.getDepartureBoardByCRS(boardByCRSParams, accessToken))
//                .thenReturn(NTHTestResources.testGetBoardResponseType());
//
//        List<ServiceDeparture> serviceDepartures =
//                serviceDataService.getDepartureBoard(boardByCRSParams);
//
//        assertFalse(serviceDepartures.isEmpty());
    }
}