package com.nathanodong.nationaltrainhunterws.controller;

import com.nathanodong.nationaltrainhunterws.service.TrainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1")
public class TrainController {

    @Autowired
    private TrainService trainService;

    private final Logger logger = LoggerFactory.getLogger(TrainController.class);

    @RequestMapping("/eta")
    public String fuck(@RequestParam(value = "crs") String crs) {
        return trainService.getDepartureBoard(crs);
    }
}
