package controllers;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ReadServiceFeatures {
    private static final String TIME_RANGE = "time_range";
    private static final String TIME_MIN = "time_min";
    private static final String COST_RANGE = "cost_range";
    private static final String COST_MIN = "cost_min";
    private static final String file = "/tmp/soc/sc.xlsx";
    public static void main(String[] args) {
        Map<Integer, List<ServiceFeature>> features = getPercentageMap(file);
        System.out.println(1);
    }
    static Map<Integer, List<ServiceFeature>> getFeaturesMap(){
        Map<Integer, List<ServiceFeature>> features = getPercentageMap(file);
        return features;
    }

    private static Map<Integer, List<ServiceFeature>> getPercentageMap(String fileName){
        Map<Integer, List<ServiceFeature>> featuresMap = readFromConfig(fileName);
        Map<String, Double> timeMap = getRangeAndMinValueForTime(featuresMap);
        Map<String, Double> costMap = getRangeAndMinValueForCost(featuresMap);
        Double minTime = timeMap.get(TIME_MIN);
        Double timeRange = timeMap.get(TIME_RANGE);
        Double minCost = costMap.get(COST_MIN);
        Double costRange = costMap.get(COST_RANGE);
        for(Map.Entry<Integer, List<ServiceFeature>> entry : featuresMap.entrySet()){
            List<ServiceFeature> features = entry.getValue();
            for(ServiceFeature feature : features){
                feature.setAvailability(feature.getAvailabilityI()/100);
                feature.setReliability(feature.getReliabilityI()/100);
                feature.setTime(normalize(feature.getTimeI(), minTime, timeRange));
                feature.setCost(normalize(feature.getCostI(), minCost, costRange));
            }
        }
        return featuresMap;
    }

    private static Map<String, Double> getRangeAndMinValueForTime(Map<Integer, List<ServiceFeature>> featuresMap){
        List<ServiceFeature> features = getAllFeatures(featuresMap);
        Double timeRange = getTimeRange(features);
        Double minTime = features.get(features.size()-1).getTimeI();
        Map<String, Double> timeResult = new HashMap<String, Double>();
        timeResult.put(TIME_RANGE, timeRange);
        timeResult.put(TIME_MIN, minTime);
        return timeResult;
    }

    private static Map<String, Double> getRangeAndMinValueForCost(Map<Integer, List<ServiceFeature>> featuresMap){
        List<ServiceFeature> features = getAllFeatures(featuresMap);
        Double costRange = getCostRange(features);
        Double mincost = features.get(features.size()-1).getCostI();
        Map<String, Double> costResult = new HashMap<String, Double>();
        costResult.put(COST_RANGE, costRange);
        costResult.put(COST_MIN, mincost);
        return costResult;
    }


    private static List<ServiceFeature> getAllFeatures( Map<Integer, List<ServiceFeature>> featuresMap ){
        List<ServiceFeature> allFeatures = new ArrayList<ServiceFeature>();
        for(Map.Entry<Integer, List<ServiceFeature>> entry : featuresMap.entrySet()){
            allFeatures.addAll(entry.getValue());
        }
        return allFeatures;
    }

    private static Double normalize(Double timeI, Double minTime, Double range) {
        return (timeI-minTime)/range;
    }

    private static Double getTimeRange(List<ServiceFeature> features) {
        Collections.sort(features, new Comparator<ServiceFeature>() {
            public int compare(ServiceFeature o1, ServiceFeature o2) {
                if(o1.getTimeI().equals(o2.getTimeI())){
                    return 0;
                }
                return o1.getTimeI() < o2.getTimeI() ? 1 : -1;
            }
        });
        return Math.abs(features.get(0).getTimeI() - features.get(features.size()-1).getTimeI());
    }

    private static Double getCostRange(List<ServiceFeature> features) {
        Collections.sort(features, new Comparator<ServiceFeature>() {
            public int compare(ServiceFeature o1, ServiceFeature o2) {
                if(o1.getCostI().equals(o2.getCostI())){
                    return 0;
                }
                return o1.getCostI() < o2.getCostI() ? 1 : -1;
            }
        });
        return Math.abs(features.get(0).getCostI() - features.get(features.size()-1).getCostI());
    }


    static Map<Integer, List<ServiceFeature>> readFromConfig(String fileName){
        Map<Integer, List<ServiceFeature>> featureMap = new HashMap<Integer, List<ServiceFeature>>();
        try {
            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(fileName));

            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            Row headerRow= rowIterator.next();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
                int n = 0;
                Integer serviceCluster = -1;
                List<ServiceFeature> features;
                ServiceFeature feature = new ServiceFeature();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    //Check the cell type and format accordingly
                    switch (n){
                        case 0:
                            String serviceClusterStr = cell.getStringCellValue();
                            if(serviceClusterStr.equals("SC1")){
                                serviceCluster = 0;
                            }
                            if(serviceClusterStr.equals("SC2")){
                                serviceCluster = 1;
                            }
                            if(serviceClusterStr.equals("SC3")){
                                serviceCluster = 2;
                            }
                            break;
                        case 1:
                            String serviceName = cell.getStringCellValue();
                            feature.setServiceName(serviceName);
                            break;
                        case 2:
                            Double cost = cell.getNumericCellValue();
                            feature.setCostI(cost);
                            break;
                        case 3:
                            Double reliability = cell.getNumericCellValue();
                            feature.setReliabilityI(reliability);
                            break;
                        case 4:
                            Double time = cell.getNumericCellValue();
                            feature.setTimeI(time);
                            break;
                        case 5:
                            Double available = cell.getNumericCellValue();
                            feature.setAvailabilityI(available);
                            break;
                    }
                    n++;
                }
                if(featureMap.containsKey(serviceCluster)){
                    features = featureMap.get(serviceCluster);
                } else {
                    features = new ArrayList<ServiceFeature>();
                    featureMap.put(serviceCluster, features);
                }
                features.add(feature);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return featureMap;
    }
}
