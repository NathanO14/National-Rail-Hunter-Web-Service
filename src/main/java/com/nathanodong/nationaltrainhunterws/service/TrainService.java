package com.nathanodong.nationaltrainhunterws.service;

import com.thalesgroup.rtti._2013_11_28.token.types.AccessToken;
import com.thalesgroup.rtti._2017_10_01.ldb.GetBoardRequestParams;
import com.thalesgroup.rtti._2017_10_01.ldb.LDBServiceSoap;
import com.thalesgroup.rtti._2017_10_01.ldb.Ldb;
import com.thalesgroup.rtti._2017_10_01.ldb.StationBoardResponseType;
import com.thalesgroup.rtti._2017_10_01.ldb.types.ServiceItem;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.ext.logging.LoggingInInterceptor;
import org.apache.cxf.ext.logging.LoggingOutInterceptor;
import org.apache.cxf.frontend.ClientProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainService {

    @Value("${nationalrail.ldb.token}")
    private String LDB_TOKEN;

    private final Logger logger = LoggerFactory.getLogger(TrainService.class);

    public String getDepartureBoard(String crs) {
        AccessToken accessToken = new AccessToken();
        accessToken.setTokenValue(LDB_TOKEN);

        Ldb soap = new Ldb();
        LDBServiceSoap soapService = soap.getLDBServiceSoap12();

        /*
         * To examine the request and responses sent to the service
         */
        Client client = ClientProxy.getClient(soapService);
        client.getInInterceptors().add(new LoggingInInterceptor());
        client.getOutInterceptors().add(new LoggingOutInterceptor());

        GetBoardRequestParams params = new GetBoardRequestParams();
        params.setCrs(crs);

        StationBoardResponseType departureBoard = soapService.getDepartureBoard(params, accessToken);

        logger.info("Trains at {}", departureBoard.getGetStationBoardResult().getLocationName());
        logger.info("===============================================================================");

        List<ServiceItem> service = departureBoard.getGetStationBoardResult().getTrainServices().getService();

        for (ServiceItem si : service) {

            logger.info("{} to {} - {}", si.getStd(), si.getDestination().getLocation().get(0).getLocationName(), si.getEtd());

        }

        return "";
    }
}
