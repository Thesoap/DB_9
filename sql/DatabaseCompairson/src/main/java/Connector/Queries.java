package Connector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Queries {

    public static void main(String[] args) throws Exception {
        //Query 1
        long End1_STime = System.nanoTime();
        for (int i = 0; i < 20; i++) {
            EndorsementsOne();
        }
        long End1_ETime = System.nanoTime();
        long End1_TotalTime = ((End1_ETime - End1_STime) / 20);

        //Query 2
        long End2_STime = System.nanoTime();
        for (int i = 0; i < 20; i++) {
            EndorsementsTwo();
        }
        long End2_ETime = System.nanoTime();
        long End2_TotalTime = ((End2_ETime - End2_STime) / 20);

        //Query 3
        long End3_STime = System.nanoTime();
        for (int i = 0; i < 20; i++) {
            EndorsementsThree();
        }
        long End3_ETime = System.nanoTime();
        long End3_TotalTime = ((End3_ETime - End3_STime) / 20);

        //Query 4
        long End4_STime = System.nanoTime();
        for (int i = 0; i < 20; i++) {
            EndorsementsFour();
        }
        long End4_ETime = System.nanoTime();
        long End4_TotalTime = ((End4_ETime - End4_STime) / 20);

        //Query 5
        long End5_STime = System.nanoTime();
        for (int i = 0; i < 20; i++) {
            EndorsementsFive();
        }
        long End5_ETime = System.nanoTime();
        long End5_TotalTime = ((End5_ETime - End5_STime) / 20);
        
        System.out.println("SQL:");
        System.out.println("Depth1: " + End1_TotalTime);
        System.out.println("Depth2: " + End2_TotalTime);
        System.out.println("Depth3: " + End3_TotalTime);
        System.out.println("Depth4: " + End4_TotalTime);
        System.out.println("Depth5: " + End5_TotalTime);

    }

    public static void EndorsementsOne() throws Exception {
        Connection con = new DBConnector().getConnection();
        Statement state = con.createStatement();

        String query = "SELECT * FROM nodes WHERE node_id IN(\n"
                + "SELECT target_id FROM edges WHERE edge_id IN(\n"
                + "SELECT node_id FROM nodes WHERE name = 'Odessa Satmary'))";
        ResultSet res = state.executeQuery(query);
    }

    public static void EndorsementsTwo() throws Exception {
        Connection con = new DBConnector().getConnection();
        Statement state = con.createStatement();

        String query = "SELECT * FROM nodes WHERE node_id IN(\n"
                + "SELECT target_id FROM edges WHERE edge_id IN(\n"
                + "SELECT target_id FROM edges WHERE edge_id IN(\n"
                + "SELECT node_id FROM nodes WHERE name = 'Odessa Satmary')))";
        ResultSet res = state.executeQuery(query);
    }

    public static void EndorsementsThree() throws Exception {
        Connection con = new DBConnector().getConnection();
        Statement state = con.createStatement();

        String query = "SELECT * FROM nodes WHERE node_id IN(\n"
                + "SELECT target_id FROM edges WHERE edge_id IN(\n"
                + "SELECT target_id FROM edges WHERE edge_id IN(\n"
                + "SELECT target_id FROM edges WHERE edge_id IN(\n"
                + "SELECT node_id FROM nodes WHERE name = 'Odessa Satmary'))))";
        ResultSet res = state.executeQuery(query);
    }

    public static void EndorsementsFour() throws Exception {
        Connection con = new DBConnector().getConnection();
        Statement state = con.createStatement();

        String query = "SELECT * FROM nodes WHERE node_id IN(\n"
                + "SELECT target_id FROM edges WHERE edge_id IN(\n"
                + "SELECT target_id FROM edges WHERE edge_id IN(\n"
                + "SELECT target_id FROM edges WHERE edge_id IN(\n"
                + "SELECT target_id FROM edges WHERE edge_id IN(\n"
                + "SELECT node_id FROM nodes WHERE name = 'Odessa Satmary')))))";
        ResultSet res = state.executeQuery(query);
    }

    public static void EndorsementsFive() throws Exception {
        Connection con = new DBConnector().getConnection();
        Statement state = con.createStatement();

        String query = "SELECT * FROM nodes WHERE node_id IN(\n"
                + "SELECT target_id FROM edges WHERE edge_id IN(\n"
                + "SELECT target_id FROM edges WHERE edge_id IN(\n"
                + "SELECT target_id FROM edges WHERE edge_id IN(\n"
                + "SELECT target_id FROM edges WHERE edge_id IN(\n"
                + "SELECT target_id FROM edges WHERE edge_id IN(\n"
                + "SELECT node_id FROM nodes WHERE name = 'Odessa Satmary'))))))";
        ResultSet res = state.executeQuery(query);
    }
}
