package com.nathanodong.nationaltrainhunterws.service;

import com.nathanodong.nationaltrainhunterws.model.Station;
import com.thalesgroup.rtti._2013_11_28.token.types.AccessToken;
import com.thalesgroup.rtti._2015_05_14.ldbsv_ref.GetStationListResponseType;
import com.thalesgroup.rtti._2015_05_14.ldbsv_ref.GetVersionedRefDataRequestParams;
import com.thalesgroup.rtti._2015_05_14.ldbsv_ref.LDBSVRefServiceSoap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StationService {

    private final AccessToken accessToken;

    private final LDBSVRefServiceSoap ldbsvRefServiceSoap;

    @Autowired
    public StationService(AccessToken accessToken, LDBSVRefServiceSoap ldbsvRefServiceSoap) {
        this.accessToken = accessToken;
        this.ldbsvRefServiceSoap = ldbsvRefServiceSoap;
    }

    public List<Station> getStationsBySearchTerm(String searchTerm) {
        GetVersionedRefDataRequestParams params = new GetVersionedRefDataRequestParams();
        params.setCurrentVersion(null);

        GetStationListResponseType response = ldbsvRefServiceSoap.getStationList(params, accessToken);
        return response.getGetStationListResult().getStationList().getStation()
                .stream()
                .filter(stationName -> stationName.getCrs().equals(searchTerm.toUpperCase()) ||
                        stationName.getValue().toLowerCase().startsWith(searchTerm.toLowerCase()))
                .map(stationName -> new Station(stationName.getCrs(), stationName.getValue()))
                .collect(Collectors.toList());
    }
}
