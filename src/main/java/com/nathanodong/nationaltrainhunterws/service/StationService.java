package com.nathanodong.nationaltrainhunterws.service;

import com.nathanodong.nationaltrainhunterws.model.Station;
import com.nathanodong.nationaltrainhunterws.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationService {

    @Autowired
    private StationRepository stationRepository;

    public List<Station> getStations(Pageable pageable) {
        return stationRepository.findAll(pageable).getContent();
    }

    public List<Station> getStationsBySearchTerm(String searchTerm, Pageable pageable) {
        return stationRepository.findByStationCodeOrStationName(searchTerm, pageable);
    }
}
