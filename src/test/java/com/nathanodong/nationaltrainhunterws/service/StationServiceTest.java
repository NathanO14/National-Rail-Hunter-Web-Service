package com.nathanodong.nationaltrainhunterws.service;

import com.nathanodong.nationaltrainhunterws.model.Station;
import com.nathanodong.nationaltrainhunterws.repository.StationRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class StationServiceTest {

    @Autowired
    private StationService stationService;

    @Autowired
    private StationRepository stationRepository;

    private Station station;

    @BeforeEach
    void setUp() {
        station = stationRepository.save(new Station("NWX", "New Cross"));
    }

    @AfterEach
    void tearDown() {
        stationRepository.deleteAll();
    }

    @Test
    void getStations() {
        List<Station> stations = stationService.getStations(Pageable.unpaged());

        assertFalse(stations.isEmpty());
        assertEquals(station.getStationCode(), stations.get(0).getStationCode());
        assertEquals(station.getStationName(), stations.get(0).getStationName());
    }

    @Test
    void getStationsBySearchTerm() {
        List<Station> stations = stationService.getStationsBySearchTerm("Ne", Pageable.unpaged());

        assertFalse(stations.isEmpty());
        assertEquals(station.getStationCode(), stations.get(0).getStationCode());
        assertEquals(station.getStationName(), stations.get(0).getStationName());
    }
}