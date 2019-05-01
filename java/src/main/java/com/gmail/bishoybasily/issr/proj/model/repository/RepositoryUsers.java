package com.gmail.bishoybasily.issr.proj.model.repository;

import com.gmail.bishoybasily.issr.proj.model.entity.User;
import com.zaxxer.hikari.HikariDataSource;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepositoryUsers {

    private HikariDataSource hikariDataSource;

    @Inject
    public RepositoryUsers(HikariDataSource hikariDataSource) {
        this.hikariDataSource = hikariDataSource;
    }

    public User getOne(Long id) throws SQLException {

        User user = null;

        Connection connection = hikariDataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT id, name, email, telephone FROM users WHERE users.id=?");
        statement.setLong(1, id);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next())
            user = getUser(resultSet);

        return user;
    }


    public List<User> getAll() throws SQLException {

        List<User> users = new ArrayList<>();

        Connection connection = hikariDataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT id, name, email, telephone FROM users");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next())
            users.add(getUser(resultSet));

        return users;

    }

    private User getUser(ResultSet resultSet) throws SQLException {
        return new User()
                .setId(new SimpleLongProperty(resultSet.getLong("id")))
                .setName(new SimpleStringProperty(resultSet.getString("name")))
                .setEmail(new SimpleStringProperty(resultSet.getString("email")))
                .setTelephone(new SimpleStringProperty(resultSet.getString("telephone")));
    }

}
