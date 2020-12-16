package com.nathanodong.nationaltrainhunterws.service;

import com.nathanodong.nationaltrainhunterws.AbstractNTHIntegrationTest;
import com.nathanodong.nationaltrainhunterws.model.Station;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StationServiceTest extends AbstractNTHIntegrationTest {

    @Autowired
    private StationService stationService;

    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getStationsBySearchTerm() {
        List<Station> stations = stationService.getStationsBySearchTerm("Ne");

        assertFalse(stations.isEmpty());
    }
}