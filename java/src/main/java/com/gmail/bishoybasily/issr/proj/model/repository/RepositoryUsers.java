package com.gmail.bishoybasily.issr.proj.model.repository;

import com.gmail.bishoybasily.issr.proj.model.entity.User;
import com.zaxxer.hikari.HikariDataSource;

import javax.inject.Inject;
import java.sql.*;
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
        String sql = "SELECT id, name, email, telephone FROM users WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, id);
        ResultSet set = statement.executeQuery();

        if (set.next())
            user = new User(set.getLong("id"), set.getString("name"), set.getString("email"), set.getString("telephone"));

        statement.close();

        return user;
    }

    public List<User> getAll() throws SQLException {

        List<User> users = new ArrayList<>();

        Connection connection = hikariDataSource.getConnection();
        String sql = "SELECT id, name, email, telephone FROM users";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet set = statement.executeQuery();

        while (set.next())
            users.add(new User(set.getLong("id"), set.getString("name"), set.getString("email"), set.getString("telephone")));

        statement.close();

        return users;
    }

    public User save(User user) throws SQLException {

        Connection connection = hikariDataSource.getConnection();
        String sql = "INSERT INTO users(name, email, telephone) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, user.getName());
        statement.setString(2, user.getEmail());
        statement.setString(3, user.getTelephone());
        statement.executeUpdate();

        ResultSet set = statement.getGeneratedKeys();
        Long id = null;

        if (set.next())
            id = set.getLong(1);

        return user.setId(id);
    }

    public void delete(Long id) throws SQLException {

        Connection connection = hikariDataSource.getConnection();
        String sql = "DELETE FROM users WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, id);
        statement.executeUpdate();

    }

}
