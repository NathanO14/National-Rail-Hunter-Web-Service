package com.nathanodong.nationaltrainhunterws;

import com.thalesgroup.rtti._2017_10_01.ldbsv.GetBoardResponseType;
import com.thalesgroup.rtti._2017_10_01.ldbsv.types.ArrayOfServiceItems;
import com.thalesgroup.rtti._2017_10_01.ldbsv.types.ServiceItem;
import com.thalesgroup.rtti._2017_10_01.ldbsv.types.StationBoard;

import java.util.ArrayList;
import java.util.List;

public class NTHTestResources {

    public static ArrayOfServiceItems testTrainServices() {
        ArrayOfServiceItems trainServices = new ArrayOfServiceItems();
        trainServices.getService().addAll(testServiceItems());
        return trainServices;
    }

    public static StationBoard testStationBoard() {
        StationBoard stationBoard = new StationBoard();
        stationBoard.setLocationName("Waterloo");
        stationBoard.setTrainServices(testTrainServices());
        return stationBoard;
    }

    public static GetBoardResponseType testGetBoardResponseType() {
        GetBoardResponseType getBoardResponseType = new GetBoardResponseType();
        getBoardResponseType.setGetBoardResult(testStationBoard());
        return getBoardResponseType;
    }

    public static List<ServiceItem> testServiceItems() {
        List<ServiceItem> serviceItems = new ArrayList<>();

        ServiceItem serviceItem = new ServiceItem();
        serviceItem.setRid("202009258103064");
        serviceItem.setRsid("SW816500");
        serviceItem.setTrainid("1T65");
        serviceItem.setPlatform("15");
        serviceItem.setPlatform("15");

        serviceItems.add(serviceItem);

        return serviceItems;
    }
}
