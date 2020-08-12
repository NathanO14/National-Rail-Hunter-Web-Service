package com.nathanodong.nationaltrainhunterws.controller;

import com.nathanodong.nationaltrainhunterws.model.ServiceDeparture;
import com.nathanodong.nationaltrainhunterws.model.ServiceInformation;
import com.nathanodong.nationaltrainhunterws.service.ServiceDataService;
import com.thalesgroup.rtti._2017_10_01.ldb.GetBoardRequestParams;
import com.thalesgroup.rtti._2017_10_01.ldb.GetServiceDetailsRequestParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1")
public class ServiceDataController {

    @Autowired
    private ServiceDataService serviceDataService;

    @RequestMapping(value = "/service/departureBoard", method = RequestMethod.POST)
    public List<ServiceDeparture> getDepartureBoard(@RequestBody GetBoardRequestParams getBoardRequestParams) {
        return serviceDataService.getDepartureBoard(getBoardRequestParams);
    }

    @RequestMapping(value = "/service/details", method = RequestMethod.POST)
    public ServiceInformation getServiceDetails(@RequestBody GetServiceDetailsRequestParams getServiceDetailsRequestParams) {
        return serviceDataService.getServiceDetails(getServiceDetailsRequestParams);
    }
}
