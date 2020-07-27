package com.nathanodong.nationaltrainhunterws.service;

import com.nathanodong.nationaltrainhunterws.AbstractNTHIntegrationTest;
import com.nathanodong.nationaltrainhunterws.model.Journey;
import com.thalesgroup.rtti._2007_10_10.ldb.commontypes.FilterType;
import com.thalesgroup.rtti._2017_10_01.ldb.GetBoardRequestParams;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class JourneyServiceTest extends AbstractNTHIntegrationTest {

    @Autowired
    private JourneyService journeyService;

    @Test
    void getDepartureBoard() {
//        mockWebResponse("xml/GetDepartureBoardResponse.xml", 200);

        GetBoardRequestParams params = new GetBoardRequestParams();
        params.setCrs("STP");
//        params.setFilterCrs("CST");
        params.setFilterType(FilterType.TO);

        List<Journey> journeys = journeyService.getDepartureBoard(params);

        assertFalse(journeys.isEmpty());
    }
}