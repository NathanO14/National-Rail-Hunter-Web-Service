package com.nathanodong.nationaltrainhunterws.service;

import com.nathanodong.nationaltrainhunterws.AbstractNTHIntegrationTest;
import com.nathanodong.nationaltrainhunterws.model.Station;
import com.nathanodong.nationaltrainhunterws.repository.StationRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StationServiceTest extends AbstractNTHIntegrationTest {

    @Autowired
    private StationService stationService;

    @Autowired
    private StationRepository stationRepository;

    private Station station;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        station = stationRepository.save(new Station("NWX", "New Cross"));
    }

    @After
    public void tearDown() {
        stationRepository.deleteAll();
    }

    @Test
    public void getStations() {
        List<Station> stations = stationService.getStations(Pageable.unpaged());

        assertFalse(stations.isEmpty());
        assertEquals(station.getStationCode(), stations.get(0).getStationCode());
        assertEquals(station.getStationName(), stations.get(0).getStationName());
    }

    @Test
    public void getStationsBySearchTerm() {
        List<Station> stations = stationService.getStationsBySearchTerm("Ne", Pageable.unpaged());

        assertFalse(stations.isEmpty());
        assertEquals(station.getStationCode(), stations.get(0).getStationCode());
        assertEquals(station.getStationName(), stations.get(0).getStationName());
    }
}