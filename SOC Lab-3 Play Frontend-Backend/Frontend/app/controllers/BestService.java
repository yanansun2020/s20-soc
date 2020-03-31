package controllers;

import lombok.Data;

@Data
public class BestService {
    public BestService() {
    }

    public BestService(int index, String serviceName) {
        this.index = index;
        this.serviceName = serviceName;
    }

    private int index;
    private String serviceName;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}
