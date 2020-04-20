package controllers;

import org.jgap.FitnessFunction;
import org.jgap.IChromosome;

import java.util.List;
import java.util.Map;

/**
 * Sample fitness function for the MakeChange example.
 *
 * @author Neil Rotstan
 * @author Klaus Meffert
 * @since 1.0
 */
public class CalculateServiceClusterFunction
    extends FitnessFunction {

  static Map<Integer, List<ServiceFeature>> serviceFeatures = ReadServiceFeatures.getFeaturesMap();
  private static final Double COST_WEIGHT = 0.35;
  private static final Double RELIABLE_WEIGHT = 0.1;
  private static final Double TIME_WEIGHT = 0.2;
  private static final Double AVAILABLE_WEIGHT = 0.35;

  public CalculateServiceClusterFunction() {
  }

  /**
   * Determine the fitness of the given Chromosome instance. The higher the
   * return value, the more fit the instance. This method should always
   * return the same fitness value for two equivalent Chromosome instances.
   *
   * @param a_subject the Chromosome instance to evaluate
   *
   * @return positive double reflecting the fitness rating of the given
   * Chromosome
   * @since 2.0 (until 1.1: return type int)
   * @author Neil Rotstan, Klaus Meffert, John Serri
   */
  public double evaluate(IChromosome a_subject) {
    Double fitness = getFitness(a_subject);
    return Math.max(1.0D, fitness);
  }

  public static Double getFitness(IChromosome a_potentialSolution){
    ServiceFeature serviceFeature = getFinalServiceFeature(a_potentialSolution);
    return COST_WEIGHT * serviceFeature.getCost() + RELIABLE_WEIGHT * serviceFeature.getReliability() +
            TIME_WEIGHT * serviceFeature.getTime() + AVAILABLE_WEIGHT * serviceFeature.getAvailability();
  }
  public static ServiceFeature getFinalServiceFeature(IChromosome a_potentialSolution) {
    int sc1Index = getIndexOfService(a_potentialSolution, 0);
    int sc2Index = getIndexOfService(a_potentialSolution, 1);
    int sc3Index = getIndexOfService(a_potentialSolution, 2);

    return getFeaturesByIndex(sc1Index, sc2Index, sc3Index);
  }

  private static ServiceFeature getFeaturesByIndex(int sc1Index, int sc2Index, int sc3Index) {
    List<ServiceFeature> cluster1Features = serviceFeatures.get(0);
    ServiceFeature serviceFeature1 = cluster1Features.get(sc1Index);

    List<ServiceFeature> cluster2Features = serviceFeatures.get(1);
    ServiceFeature serviceFeature2 = cluster2Features.get(sc2Index);
    //get the output of s2,  name W1, so W1 = seq (s1, s2)
    ServiceFeature w1 = seq(serviceFeature1, serviceFeature2);
    //get the input of s3,    name W2, so W2 = join (W, s1)
    ServiceFeature w2 = join(w1, serviceFeature1);
    List<ServiceFeature> cluster3Features = serviceFeatures.get(2);
    ServiceFeature serviceFeature3 = cluster3Features.get(sc3Index);
    //get the output of s3,  name W3, so W3= seq (W2, s3)
    ServiceFeature w3 = seq(w2, serviceFeature3);
    return w3;
  }

  private static ServiceFeature seq(ServiceFeature serviceFeature1, ServiceFeature serviceFeature2) {
    ServiceFeature serviceFeature = new ServiceFeature();
    Double reliability = Math.min(serviceFeature1.getReliability(), serviceFeature2.getReliability());
    serviceFeature.setReliability(reliability);
    Double availability = Math.min(serviceFeature1.getAvailability(), serviceFeature2.getAvailability());
    serviceFeature.setAvailability(availability);
    Double cost = serviceFeature1.getCost() + serviceFeature2.getCost();
    serviceFeature.setCost(cost);
    Double performance = serviceFeature1.getTime() + serviceFeature2.getTime();
    serviceFeature.setTime(performance);
    return serviceFeature;
  }

  private static ServiceFeature join(ServiceFeature serviceFeature1, ServiceFeature serviceFeature2) {
    ServiceFeature serviceFeature = new ServiceFeature();
    Double reliability = serviceFeature1.getReliability() * serviceFeature2.getReliability();
    serviceFeature.setReliability(reliability);
    Double availability = serviceFeature1.getAvailability() * serviceFeature2.getAvailability();
    serviceFeature.setAvailability(availability);
    Double cost = serviceFeature1.getCost() + serviceFeature2.getCost();
    serviceFeature.setCost(cost);
    Double performance = Math.max(serviceFeature1.getTime(), serviceFeature2.getTime());
    serviceFeature.setTime(performance);
    return serviceFeature;
  }

  /**
   * Retrieves the number of coins represented by the given potential
   * solution at the given gene position.
   *
   * @param a_potentialSolution the potential solution to evaluate
   * @param a_position the gene position to evaluate
   * @return the number of coins represented by the potential solution at the
   * given gene position
   *
   * @author Neil Rotstan
   * @since 1.0
   */
  public static int getIndexOfService(IChromosome a_potentialSolution,
                                      int a_position) {
    Integer index =
        (Integer) a_potentialSolution.getGene(a_position).getAllele();
    return index.intValue();
  }
}
