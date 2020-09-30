package com.nathanodong.nationaltrainhunterws.model;

import java.util.List;

public class ServiceDepartureResult {

    private List<ServiceDeparture> serviceDepartures;

    private List<ServiceMessage> serviceMessages;

    public ServiceDepartureResult() {
    }

    public ServiceDepartureResult(List<ServiceDeparture> serviceDepartures, List<ServiceMessage> serviceMessages) {
        this.serviceDepartures = serviceDepartures;
        this.serviceMessages = serviceMessages;
    }

    public List<ServiceDeparture> getServiceDepartures() {
        return serviceDepartures;
    }

    public void setServiceDepartures(List<ServiceDeparture> serviceDepartures) {
        this.serviceDepartures = serviceDepartures;
    }

    public List<ServiceMessage> getServiceMessages() {
        return serviceMessages;
    }

    public void setServiceMessages(List<ServiceMessage> serviceMessages) {
        this.serviceMessages = serviceMessages;
    }
}
