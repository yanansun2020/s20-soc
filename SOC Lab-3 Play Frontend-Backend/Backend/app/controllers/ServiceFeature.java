package controllers;

import lombok.Data;

@Data
public class ServiceFeature {
    private String serviceName;
    private Double costI;
    private Double reliabilityI;
    private Double timeI;
    private Double availabilityI;

    private Double cost;
    private Double reliability;
    private Double time;
    private Double availability;


    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Double getCostI() {
        return costI;
    }

    public void setCostI(Double costI) {
        this.costI = costI;
    }

    public Double getReliabilityI() {
        return reliabilityI;
    }

    public void setReliabilityI(Double reliabilityI) {
        this.reliabilityI = reliabilityI;
    }

    public Double getTimeI() {
        return timeI;
    }

    public void setTimeI(Double timeI) {
        this.timeI = timeI;
    }

    public Double getAvailabilityI() {
        return availabilityI;
    }

    public void setAvailabilityI(Double availabilityI) {
        this.availabilityI = availabilityI;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getReliability() {
        return reliability;
    }

    public void setReliability(Double reliability) {
        this.reliability = reliability;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public Double getAvailability() {
        return availability;
    }

    public void setAvailability(Double availability) {
        this.availability = availability;
    }
}
