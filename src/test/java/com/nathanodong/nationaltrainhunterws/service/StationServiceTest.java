package com.nathanodong.nationaltrainhunterws.service;

import com.nathanodong.nationaltrainhunterws.model.Station;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StationServiceTest {

    @Autowired
    private StationService stationService;

    @Test
    public void getStationsBySearchTerm() throws Exception {
        List<Station> stations = stationService.getStationsBySearchTerm("Ne");
        assertFalse(stations.isEmpty());

        List<StationExpectation> expectations = Arrays.asList(
                new StationExpectation("NWX", "New Cross"),
                new StationExpectation("NXG", "New Cross Gate")
        );

        expectations.forEach(stationExpectation -> {
            Station expectedStation = stations.stream()
                    .filter(station -> station.getStationCode().equals(stationExpectation.stationCode))
                    .findFirst()
                    .orElse(null);
            stationExpectation.assertStation(expectedStation);
        });
    }

    @Test
    public void getStationsBySearchTermByCRS() throws Exception {
        List<Station> stations = stationService.getStationsBySearchTerm("kng");
        assertFalse(stations.isEmpty());

        List<StationExpectation> expectations = Arrays.asList(
                new StationExpectation("KNG", "Kingston")
        );

        expectations.forEach(stationExpectation -> {
            Station expectedStation = stations.stream()
                    .filter(station -> station.getStationCode().equals(stationExpectation.stationCode))
                    .findFirst()
                    .orElse(null);
            stationExpectation.assertStation(expectedStation);
        });
    }

    private static class StationExpectation {
        private final String stationCode;
        private final String stationName;

        private StationExpectation(String stationCode, String stationName) {
            this.stationCode = stationCode;
            this.stationName = stationName;
        }

        private void assertStation(Station station) {
            assertNotNull(station);
            assertEquals(stationCode, station.getStationCode());
            assertEquals(stationName, station.getStationName());
        }
    }
}