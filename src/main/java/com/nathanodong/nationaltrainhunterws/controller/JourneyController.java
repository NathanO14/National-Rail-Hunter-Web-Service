package com.nathanodong.nationaltrainhunterws.controller;

import com.nathanodong.nationaltrainhunterws.model.Journey;
import com.nathanodong.nationaltrainhunterws.service.JourneyService;
import com.thalesgroup.rtti._2017_10_01.ldb.GetBoardRequestParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/journeys")
public class JourneyController {

    @Autowired
    private JourneyService journeyService;

    private final Logger logger = LoggerFactory.getLogger(JourneyController.class);

    @RequestMapping("/departureBoard")
    public List<Journey> getDepartureBoard(GetBoardRequestParams getBoardRequestParams) {
        return journeyService.getDepartureBoard(getBoardRequestParams);
    }
}
