package edu.metrostate.service;

import edu.metrostate.Util;
import edu.metrostate.migrations.Migrations;
import edu.metrostate.model.Restaurant;

import java.io.Closeable;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DatabaseImplementation implements DatabaseInterface{

    private final String databaseName = "test.db";
    private final String connectionString = "jdbc:sqlite:" + databaseName;

    private Connection connection = null;

    private RestaurantService rs;
    protected static DatabaseImplementation instance;

    private List<Restaurant> restaurants;
    private DatabaseImplementation () {
        migrate();
    }
    public static  DatabaseImplementation getInstance() {
        if (instance == null) {
            instance = new DatabaseImplementation();
        }
        return instance;
    }


    @Override
    public void openConnection() {
        try {
            if (connection == null) {
                connection = DriverManager.getConnection(connectionString);
                rs = new RestaurantService(connection);
            }

        } catch (
                SQLException ex) {
             ex.printStackTrace();
        }
    }


    public static void closeQuietly(Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (Exception ex) {
            // close quietly
        }
    }

    public static void closeQuietly(AutoCloseable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (Exception ex) {
            // close quietly
        }
    }

    @Override
    public void migrate() {
        openConnection();
        Migrations m = new Migrations();
        m.runMigrations(connection);
    }

   public void list() {
        openConnection();
        restaurants = rs.loadResturants();
       // for (Restaurant restaurant : restaurants) {
        //    System.out.println(restaurant);
       // }


    }

    public ArrayList<String> getCategories() {
        ArrayList<String> list = new ArrayList<>();
        for (Restaurant restaurant : restaurants) {
            list.add(restaurant.getCategory());
        }
        Set<String> uniqueStringSet = new HashSet<>(list); // Convert list to set
        return new ArrayList<>(uniqueStringSet);
    }
}
