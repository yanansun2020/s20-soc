package service;

import java.math.BigDecimal;

public class Rows  {
    private String originAddresses;
    private String destinationAddresses;
    private String distance;
    private String duration;
    private String distanceByKm;

    public String getOriginAddresses() {
        return originAddresses;
    }

    public void setOriginAddresses(String originAddresses) {
        this.originAddresses = originAddresses;
    }

    public String getDestinationAddresses() {
        return destinationAddresses;
    }

    public void setDestinationAddresses(String destinationAddresses) {
        this.destinationAddresses = destinationAddresses;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDistanceByKm() {
        BigDecimal bDistance = new BigDecimal(distance);
        bDistance = bDistance.divide(new BigDecimal(1000), 2, BigDecimal.ROUND_HALF_UP);
        return bDistance.toString();
    }

    public void setDistanceByKm(String distanceByKm) {
        this.distanceByKm = distanceByKm;
    }

}
