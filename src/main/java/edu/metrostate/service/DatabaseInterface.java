package edu.metrostate.service;

public interface DatabaseInterface {
    public static DatabaseInterface getInstance() { return null; }
    public default void openConnection() {}

    public default void migrate() { }

}
