package edu.metrostate.service;

import edu.metrostate.Util;
import edu.metrostate.migrations.Migrations;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseImplementation implements DatabaseInterface{

    private final String databaseName = "test.db";
    private final String connectionString = "jdbc:sqlite:" + databaseName;

    private Connection connection = null;

    private RestaurantService rs;
    protected static DatabaseImplementation instance;
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
            // ex.printStackTrace();
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
    }
}
