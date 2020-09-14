package com.nathanodong.nationaltrainhunterws.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Station")
@Table(name = "Station")
public class Station {

    @Id
    private String stationCode;

    @Column
    private String stationName;

    public Station() {
    }

    public Station(String stationCode, String stationName) {
        this.stationCode = stationCode;
        this.stationName = stationName;
    }

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }
}
