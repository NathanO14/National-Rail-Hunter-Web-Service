package com.nathanodong.nationaltrainhunterws.model;

import com.thalesgroup.rtti._2007_10_10.ldb.commontypes.ServiceType;

import java.util.List;

public class ServiceInformation {

    private String rid;

    private String rsId;

    private String serviceId;

    private String operator;

    private ServiceType serviceType;

    private List<ServiceCallingPoint> callingPoints;

    public ServiceInformation() {
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
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

    public List<ServiceCallingPoint> getCallingPoints() {
        return callingPoints;
    }

    public void setCallingPoints(List<ServiceCallingPoint> callingPoints) {
        this.callingPoints = callingPoints;
    }
}
