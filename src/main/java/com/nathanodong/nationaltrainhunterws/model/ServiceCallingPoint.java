package com.nathanodong.nationaltrainhunterws.model;

import com.thalesgroup.rtti._2015_11_27.ldbsv.commontypes.ForecastType;

import java.time.LocalDateTime;

public class ServiceCallingPoint {

    private String crs;

    private String stationName;

    private String platform;

    private LocalDateTime scheduledArrivalTime;

    private LocalDateTime actualArrivalTime;

    private LocalDateTime estimatedArrivalTime;

    private ForecastType arrivalType;

    private LocalDateTime scheduledDepartureTime;

    private LocalDateTime actualDepartureTime;

    private LocalDateTime estimatedDepartureTime;

    private ForecastType departureType;

    private boolean cancelled;

    public ServiceCallingPoint(){}

    public String getCrs() {
        return crs;
    }

    public void setCrs(String crs) {
        this.crs = crs;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public LocalDateTime getScheduledArrivalTime() {
        return scheduledArrivalTime;
    }

    public void setScheduledArrivalTime(LocalDateTime scheduledArrivalTime) {
        this.scheduledArrivalTime = scheduledArrivalTime;
    }

    public LocalDateTime getActualArrivalTime() {
        return actualArrivalTime;
    }

    public void setActualArrivalTime(LocalDateTime actualArrivalTime) {
        this.actualArrivalTime = actualArrivalTime;
    }

    public LocalDateTime getEstimatedArrivalTime() {
        return estimatedArrivalTime;
    }

    public void setEstimatedArrivalTime(LocalDateTime estimatedArrivalTime) {
        this.estimatedArrivalTime = estimatedArrivalTime;
    }

    public ForecastType getArrivalType() {
        return arrivalType;
    }

    public void setArrivalType(ForecastType arrivalType) {
        this.arrivalType = arrivalType;
    }

    public LocalDateTime getScheduledDepartureTime() {
        return scheduledDepartureTime;
    }

    public void setScheduledDepartureTime(LocalDateTime scheduledDepartureTime) {
        this.scheduledDepartureTime = scheduledDepartureTime;
    }

    public LocalDateTime getActualDepartureTime() {
        return actualDepartureTime;
    }

    public void setActualDepartureTime(LocalDateTime actualDepartureTime) {
        this.actualDepartureTime = actualDepartureTime;
    }

    public LocalDateTime getEstimatedDepartureTime() {
        return estimatedDepartureTime;
    }

    public void setEstimatedDepartureTime(LocalDateTime estimatedDepartureTime) {
        this.estimatedDepartureTime = estimatedDepartureTime;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public ForecastType getDepartureType() {
        return departureType;
    }

    public void setDepartureType(ForecastType departureType) {
        this.departureType = departureType;
    }
}
