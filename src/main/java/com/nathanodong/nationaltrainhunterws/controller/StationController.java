package com.nathanodong.nationaltrainhunterws.controller;

import com.nathanodong.nationaltrainhunterws.model.Station;
import com.nathanodong.nationaltrainhunterws.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1")
public class StationController {

    @Autowired
    private StationService stationService;

    @RequestMapping(value = "/station", method = RequestMethod.GET)
    public List<Station> getStations(@RequestParam(value = "page") int page,
                                     @RequestParam(value = "pageSize") int pageSize) {
        return stationService.getStations(PageRequest.of(page, pageSize));
    }

    @RequestMapping(value = "/station/search", method = RequestMethod.GET)
    public List<Station> getStationsBySearchTerm(@RequestParam(value = "query") String searchTerm,
                                                 @RequestParam(value = "page") int page,
                                                 @RequestParam(value = "pageSize") int pageSize) {
        return stationService.getStationsBySearchTerm(searchTerm, PageRequest.of(page, pageSize));
    }
}
