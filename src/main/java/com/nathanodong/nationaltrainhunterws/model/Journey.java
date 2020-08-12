package com.nathanodong.nationaltrainhunterws.model;

import java.time.LocalTime;

public class Journey {
    private String platform;

    private String originStation;

    private String destinationStation;

    private LocalTime scheduledDepartureTime;

    private LocalTime estimatedDepartureTime;

    private boolean isDelayed;

    private boolean isCancelled;

    public Journey() {

    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getOriginStation() {
        return originStation;
    }

    public void setOriginStation(String originStation) {
        this.originStation = originStation;
    }

    public String getDestinationStation() {
        return destinationStation;
    }

    public void setDestinationStation(String destinationStation) {
        this.destinationStation = destinationStation;
    }

    public LocalTime getScheduledDepartureTime() {
        return scheduledDepartureTime;
    }

    public void setScheduledDepartureTime(LocalTime scheduledDepartureTime) {
        this.scheduledDepartureTime = scheduledDepartureTime;
    }

    public LocalTime getEstimatedDepartureTime() {
        return estimatedDepartureTime;
    }

    public void setEstimatedDepartureTime(LocalTime estimatedDepartureTime) {
        this.estimatedDepartureTime = estimatedDepartureTime;
    }

    public boolean isDelayed() {
        return isDelayed;
    }

    public void setDelayed(boolean delayed) {
        isDelayed = delayed;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void setCancelled(boolean cancelled) {
        isCancelled = cancelled;
    }
}
