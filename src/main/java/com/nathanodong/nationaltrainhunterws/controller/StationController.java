package com.nathanodong.nationaltrainhunterws.controller;

import com.nathanodong.nationaltrainhunterws.model.Station;
import com.nathanodong.nationaltrainhunterws.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1")
public class StationController {

    private final StationService stationService;

    @Autowired
    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    @RequestMapping(value = "/station/search", method = RequestMethod.GET)
    public List<Station> getStationsBySearchTerm(@RequestParam(value = "query") String searchTerm) {
        return stationService.getStationsBySearchTerm(searchTerm);
    }
}
