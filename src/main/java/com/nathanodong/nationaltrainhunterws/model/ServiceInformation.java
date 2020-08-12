package com.nathanodong.nationaltrainhunterws.model;

import com.thalesgroup.rtti._2007_10_10.ldb.commontypes.ServiceType;

import java.util.List;

public class ServiceInformation {
    private String rsId;

    private String serviceId;

    private Integer numberOfCoaches;

    private String operator;

    private ServiceType serviceType;

    private String delayReason;

    private Boolean isCancelled;

    private List<ServiceCallingPoint> previousCallingPoints;

    private List<ServiceCallingPoint> subsequentCallingPoints;

    public ServiceInformation() {
    }

    public String getRsId() {
        return rsId;
    }

    public void setRsId(String rsId) {
        this.rsId = rsId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getNumberOfCoaches() {
        return numberOfCoaches;
    }

    public void setNumberOfCoaches(Integer numberOfCoaches) {
        this.numberOfCoaches = numberOfCoaches;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public String getDelayReason() {
        return delayReason;
    }

    public void setDelayReason(String delayReason) {
        this.delayReason = delayReason;
    }

    public Boolean getCancelled() {
        return isCancelled;
    }

    public void setCancelled(Boolean cancelled) {
        isCancelled = cancelled;
    }

    public List<ServiceCallingPoint> getPreviousCallingPoints() {
        return previousCallingPoints;
    }

    public void setPreviousCallingPoints(List<ServiceCallingPoint> previousCallingPoints) {
        this.previousCallingPoints = previousCallingPoints;
    }

    public List<ServiceCallingPoint> getSubsequentCallingPoints() {
        return subsequentCallingPoints;
    }

    public void setSubsequentCallingPoints(List<ServiceCallingPoint> subsequentCallingPoints) {
        this.subsequentCallingPoints = subsequentCallingPoints;
    }
}
