package com.mycompany.neo4j;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Neo4j ne = new Neo4j();
        HashMap<Integer, ArrayList<Double>> neo4jMap = new HashMap<>();
        neo4jMap.put(1, new ArrayList<>());
        neo4jMap.put(2, new ArrayList<>());
        neo4jMap.put(3, new ArrayList<>());
        neo4jMap.put(4, new ArrayList<>());
        ne.get20RandomIndexes().forEach((name) -> {


            ne.getDepthOne((String) name, neo4jMap); // Fast
            ne.getDepthTwo((String) name, neo4jMap); // Fast
            ne.getDepthThree((String) name, neo4jMap); // Around 10 sec
            ne.getDepthFour((String) name, neo4jMap); // Should take around 30 sec
            //ne.getDepthFive((String) name, neo4jMap); //// DON'T RUN THIS, TAKES TOO LONG - avg and median not implemented


        });
        System.out.println("Depth 1");
        System.out.println("avg: " + ne.getAverage(neo4jMap.get(1)));
        System.out.println("median" + ne.getMedian(neo4jMap.get(1)));

        System.out.println("Depth 2");
        System.out.println("avg: " + ne.getAverage(neo4jMap.get(2)));
        System.out.println("median" + ne.getMedian(neo4jMap.get(2)));

        System.out.println("Depth 3");
        System.out.println("avg: " + ne.getAverage(neo4jMap.get(3)));
        System.out.println("median" + ne.getMedian(neo4jMap.get(3)));

        System.out.println("Depth 4");
        System.out.println("avg: " + ne.getAverage(neo4jMap.get(4)));
        System.out.println("median" + ne.getMedian(neo4jMap.get(4)));
        Connection.closeDriver();
    }
}