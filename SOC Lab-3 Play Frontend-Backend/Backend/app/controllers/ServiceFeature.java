package edu.cmu.soc;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

}
