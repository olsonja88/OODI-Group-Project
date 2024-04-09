package edu.metrostate.models;

import edu.metrostate.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class Task extends SqlModel {
    private String name;
    private Integer personId;

    public Task(String name) {
        super(null);
        this.name = name;
    }

    public Task(Integer id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer id) {
        this.personId = id;
    }

    public static List<Task> loadAll(Person person, Connection connection) {
        List<Task> taskList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM task WHERE person_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, person.getId());
            Boolean result = statement.execute();
            if (result) {
                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next()) {
                    Integer id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    Task task = new Task(id, name);
                    task.setPersonId(person.getId());
                    taskList.add(task);
                }
                Util.closeQuietly(resultSet);
            }
            Util.closeQuietly(statement);
        } catch (SQLException ex) {

        }
        return taskList;
    }

    @Override
    public PreparedStatement insertStatement(Connection connection) throws SQLException {
        String sql = "INSERT INTO task (name, person_id) VALUES (?, ?) RETURNING id;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, this.name);
        statement.setInt(2, this.personId);
        return statement;
    }

    @Override
    public PreparedStatement updateStatement(Connection connection) throws SQLException {
        String sql = "UPDATE task SET name = ?, person_id = ? WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, this.name);
        statement.setInt(2, this.personId);
        statement.setInt(3, this.getId());
        return statement;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (this.getId() != null) {
            builder.append("ID: ");
            builder.append(this.getId());
            builder.append(" ");
        }
        builder.append("\"");
        builder.append(this.name);
        builder.append("\"");
        if (this.personId != null) {
            builder.append(" Person ID:");
            builder.append(this.personId);
        }
        return builder.toString();
    }
}
