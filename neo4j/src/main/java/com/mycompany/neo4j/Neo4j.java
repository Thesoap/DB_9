/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.neo4j;

/**
 *
 * @author guttesen
 */
import org.neo4j.driver.v1.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Neo4j {

    public Double getAverage(ArrayList<Double> list){
        Double totaltime = 0.0;
        for (Double dub : list) {
            totaltime += dub;
        }
        return totaltime/20;
    }

    public Double getMedian(ArrayList<Double> list) {
        int middle = list.size()/2;
        middle = middle % 2 == 0? middle - 1 : middle;
        return list.get(middle);
    }

    public List get20RandomIndexes() {
        List<String> names = new ArrayList<String>();
        Driver driver = Connection.getInstance();

        Session session = driver.session();

        // Run a query matching all nodes
        StatementResult result = session.run(
                "MATCH(a:Person) WITH a, rand() AS number RETURN a.name as name ORDER BY number LIMIT 20");

        while( result.hasNext() ) {
            Record record = result.next();
            names.add(record.get("name").asString());
        }

        session.close();
        Connection.closeDriver();


        return names;

    }

    public StatementResult getDepthOne(String name, HashMap<Integer, ArrayList<Double>> map) {
        Driver driver = Connection.getInstance();

        Session session = driver.session();
        long startTime = System.nanoTime();

        StatementResult result = session.run(
                "MATCH (:Person {name:\"" + name + "\"})-[:ENDORSES]->(p:Person)\n" +
                        "RETURN p");
        long estimatedTime = System.nanoTime() - startTime;
        ArrayList<Double> times = map.get(1);
        times.add((double) estimatedTime/1000000000.0);
        session.close();
        return result;

    }

    public StatementResult getDepthTwo(String name, HashMap<Integer, ArrayList<Double>> map) {
        Driver driver = Connection.getInstance();

        Session session = driver.session();

        long startTime = System.nanoTime();

        StatementResult result = session.run(
                "MATCH (:Person {name:\"" + name + "\"})-[:ENDORSES*..2]->(p:Person)\n" +
                        "RETURN p");
        long estimatedTime = System.nanoTime() - startTime;
        ArrayList<Double> times = map.get(2);
        times.add((double) estimatedTime/1000000000.0);
        session.close();
        return result;

    }

    public StatementResult getDepthThree(String name, HashMap<Integer, ArrayList<Double>> map) {
        Driver driver = Connection.getInstance();

        Session session = driver.session();

        long startTime = System.nanoTime();

        StatementResult result = session.run(
                "MATCH (:Person {name:\"" + name + "\"})-[:ENDORSES*..3]->(p:Person)\n" +
                        "RETURN p");

        long estimatedTime = System.nanoTime() - startTime;
        ArrayList<Double> times = map.get(3);
        times.add((double) estimatedTime/1000000000.0);
        session.close();
        return result;

    }

    public StatementResult getDepthFour(String name, HashMap<Integer, ArrayList<Double>> map) {
        Driver driver = Connection.getInstance();

        Session session = driver.session();

        long startTime = System.nanoTime();

        StatementResult result = session.run(
                "MATCH (:Person {name:\"" + name + "\"})-[:ENDORSES*..4]->(p:Person)\n" +
                        "RETURN p");

        long estimatedTime = System.nanoTime() - startTime;
        ArrayList<Double> times = map.get(4);
        times.add((double) estimatedTime/1000000000.0);

        session.close();
        return result;

    }

    public StatementResult getDepthFive(String name, HashMap<Integer, ArrayList<Double>> map) {
        Driver driver = Connection.getInstance();

        Session session = driver.session();

        long startTime = System.nanoTime();

        StatementResult result = session.run(
                "MATCH (:Person {name:\"" + name + "\"})-[:ENDORSES*..5]->(p:Person)\n" +
                        "RETURN p");

        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("Seconds: " + estimatedTime / 1000000000.0);

        session.close();
        return result;

    }


}
