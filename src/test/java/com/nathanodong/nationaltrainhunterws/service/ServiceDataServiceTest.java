package com.nathanodong.nationaltrainhunterws.service;

import com.nathanodong.nationaltrainhunterws.AbstractNTHIntegrationTest;
import com.nathanodong.nationaltrainhunterws.model.ServiceDeparture;
import com.thalesgroup.rtti._2007_10_10.ldb.commontypes.FilterType;
import com.thalesgroup.rtti._2017_10_01.ldb.GetBoardRequestParams;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class ServiceDataServiceTest extends AbstractNTHIntegrationTest {

    @Autowired
    private ServiceDataService serviceDataService;

    @Test
    void getDepartureBoard() {
//        mockWebResponse("xml/GetDepartureBoardResponse.xml", 200);

        GetBoardRequestParams params = new GetBoardRequestParams();
        params.setCrs("STP");
//        params.setFilterCrs("CST");
        params.setFilterType(FilterType.TO);

        List<ServiceDeparture> serviceDepartures = serviceDataService.getDepartureBoard(params);

        assertFalse(serviceDepartures.isEmpty());
    }
}