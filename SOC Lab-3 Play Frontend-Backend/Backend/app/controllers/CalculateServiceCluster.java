/*
 * This file is part of JGAP.
 *
 * JGAP offers a dual license model containing the LGPL as well as the MPL.
 *
 * For licensing information please see the file license.txt included with JGAP
 * or have a look at the top of class org.jgap.Chromosome which representatively
 * includes the JGAP license policy applicable for any file delivered with JGAP.
 */
package controllers;

import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.FitnessFunction;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.Population;
import org.jgap.audit.EvolutionMonitor;
import org.jgap.data.DataTreeBuilder;
import org.jgap.data.IDataCreators;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.IntegerGene;
import org.jgap.xml.XMLDocumentBuilder;
import org.jgap.xml.XMLManager;
import org.w3c.dom.Document;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MinimizingMakeChange {

    private static final int MAX_ALLOWED_EVOLUTIONS = 50;
    public static EvolutionMonitor m_monitor;

    public static BestServiceFeature makeChangeForAmount(boolean a_doMonitor)
            throws Exception {
        // Start with a DefaultConfiguration, which comes setup with the
        // most common settings.
        // -------------------------------------------------------------
        Configuration.reset();

        Configuration conf = new DefaultConfiguration();
        // Care that the fittest individual of the current population is
        // always taken to the next generation.
        // Consider: With that, the pop. size may exceed its original
        // size by one sometimes!
        // -------------------------------------------------------------
        conf.setPreservFittestIndividual(true);
        conf.setKeepPopulationSizeConstant(false);
        // Set the fitness function we want to use, which is our
        // MinimizingMakeChangeFitnessFunction. We construct it with
        // the target amount of change passed in to this method.
        // ---------------------------------------------------------
        FitnessFunction myFunc =
                new MinimizingMakeChangeFitnessFunction();
        conf.setFitnessFunction(myFunc);
        if (a_doMonitor) {
            // Turn on monitoring/auditing of evolution progress.
            // --------------------------------------------------
            m_monitor = new EvolutionMonitor();
            conf.setMonitor(m_monitor);
        }
        // Now we need to tell the Configuration object how we want our
        // Chromosomes to be setup. We do that by actually creating a
        // sample Chromosome and then setting it on the Configuration
        // object. As mentioned earlier, we want our Chromosomes to each
        // have four genes, one for each of the coin types. We want the
        // values (alleles) of those genes to be integers, which represent
        // how many coins of that type we have. We therefore use the
        // IntegerGene class to represent each of the genes. That class
        // also lets us specify a lower and upper bound, which we set
        // to sensible values for each coin type.
        // --------------------------------------------------------------
        Gene[] sampleGenes = new Gene[3];
        sampleGenes[0] = new IntegerGene(conf, 0, 4); // service cluster1
        sampleGenes[1] = new IntegerGene(conf, 0, 2); // service cluster 2
        sampleGenes[2] = new IntegerGene(conf, 0, 7); // service cluster 3
        IChromosome sampleChromosome = new Chromosome(conf, sampleGenes);
        conf.setSampleChromosome(sampleChromosome);
        // Finally, we need to tell the Configuration object how many
        // Chromosomes we want in our population. The more Chromosomes,
        // the larger number of potential solutions (which is good for
        // finding the answer), but the longer it will take to evolve
        // the population (which could be seen as bad).
        // ------------------------------------------------------------
        conf.setPopulationSize(20);

        // Create random initial population of Chromosomes.
        // Here we try to read in a previous run via XMLManager.readFile(..)
        // for demonstration purpose only!
        // -----------------------------------------------------------------
        Genotype population = Genotype.randomInitialGenotype(conf);
        ;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < MAX_ALLOWED_EVOLUTIONS; i++) {
            if (!uniqueChromosomes(population.getPopulation())) {
                throw new RuntimeException("Invalid state in generation " + i);
            }
            if (m_monitor != null) {
                population.evolve(m_monitor);
            } else {
                population.evolve();
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Total evolution time: " + (endTime - startTime)
                + " ms");
        // Save progress to file. A new run of this example will then be able to
        // resume where it stopped before! --> this is completely optional.
        // ---------------------------------------------------------------------

        // Represent Genotype as tree with elements Chromomes and Genes.
        // -------------------------------------------------------------
        DataTreeBuilder builder = DataTreeBuilder.getInstance();
        IDataCreators doc2 = builder.representGenotypeAsDocument(population);
        // create XML document from generated tree
        XMLDocumentBuilder docbuilder = new XMLDocumentBuilder();
        Document xmlDoc = (Document) docbuilder.buildDocument(doc2);
        XMLManager.writeFile(xmlDoc, new File("JGAPExample26.xml"));
        // Display the best solution we found.
        // -----------------------------------
        IChromosome bestSolutionSoFar = population.getFittestChromosome();
        double v1 = bestSolutionSoFar.getFitnessValue();
        System.out.println("The best solution has a fitness value of " +
                bestSolutionSoFar.getFitnessValue());
        bestSolutionSoFar.setFitnessValueDirectly(-1);
        System.out.println("It contains the following services: ");
        int serviceIndex0 = MinimizingMakeChangeFitnessFunction.getIndexOfService(
                bestSolutionSoFar, 0);
        String serviceName0 = MinimizingMakeChangeFitnessFunction.serviceFeatures.get(0).
                get(serviceIndex0).getServiceName();
        int serviceIndex1 = MinimizingMakeChangeFitnessFunction.getIndexOfService(
                bestSolutionSoFar, 1);
        String serviceName1 = MinimizingMakeChangeFitnessFunction.serviceFeatures.get(1)
                .get(serviceIndex1).getServiceName();
        int serviceIndex2 = MinimizingMakeChangeFitnessFunction.getIndexOfService(
                bestSolutionSoFar, 2);
        String serviceName2 = MinimizingMakeChangeFitnessFunction.serviceFeatures.get(2)
                .get(serviceIndex2).getServiceName();
        List<BestService> bestServiceList = new ArrayList<>(3);
        BestService bestService1 = new BestService(serviceIndex0, serviceName0);
        BestService bestService2 = new BestService(serviceIndex1, serviceName1);
        BestService bestService3 = new BestService(serviceIndex2, serviceName2);
        bestServiceList.add(bestService1);
        bestServiceList.add(bestService2);
        bestServiceList.add(bestService3);
        BestServiceFeature bestServiceFeature = new BestServiceFeature();
        bestServiceFeature.setBestServiceList(bestServiceList);
        bestServiceFeature.setFitness(bestSolutionSoFar.getFitnessValue());
        return bestServiceFeature;

    }

    /**
     * Main method. A single command-line argument is expected, which is the
     * amount of change to create (in other words, 75 would be equal to 75
     * cents).
     *
     * @param args amount of change in cents to create
     * @throws Exception
     * @author Neil Rotstan
     * @author Klaus Meffert
     * @since 1.0
     */
    public static void main(String[] args) {
        try {
            BestServiceFeature bestServiceFeature = makeChangeForAmount(true);
            List<BestService> services= bestServiceFeature.getBestServiceList();
            for (int i = 0; i < services.size(); i++) {
                System.out.println("Service index " + i + " which is " + services.get(i).getServiceName() + " in SC1");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param a_pop the population to verify
     * @return true if all chromosomes in the populationa are unique
     * @author Klaus Meffert
     * @since 3.3.1
     */
    public static boolean uniqueChromosomes(Population a_pop) {
        // Check that all chromosomes are unique
        for (int i = 0; i < a_pop.size() - 1; i++) {
            IChromosome c = a_pop.getChromosome(i);
            for (int j = i + 1; j < a_pop.size(); j++) {
                IChromosome c2 = a_pop.getChromosome(j);
                if (c == c2) {
                    return false;
                }
            }
        }
        return true;
    }
}
