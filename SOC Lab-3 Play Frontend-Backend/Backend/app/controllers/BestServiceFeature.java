package controllers;

import lombok.Data;

import java.util.List;
@Data
public class BestServiceFeature {
    private List<BestService> bestServiceList;
    private Double fitness;

    public List<BestService> getBestServiceList() {
        return bestServiceList;
    }

    public void setBestServiceList(List<BestService> bestServiceList) {
        this.bestServiceList = bestServiceList;
    }

    public Double getFitness() {
        return fitness;
    }

    public void setFitness(Double fitness) {
        this.fitness = fitness;
    }
}
