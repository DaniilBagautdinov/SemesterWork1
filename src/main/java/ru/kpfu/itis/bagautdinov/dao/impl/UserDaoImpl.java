package ru.kpfu.itis.bagautdinov.dao.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kpfu.itis.bagautdinov.dao.UserDao;
import ru.kpfu.itis.bagautdinov.helper.PostgresConnectionHelper;
import ru.kpfu.itis.bagautdinov.model.User;
import ru.kpfu.itis.bagautdinov.service.UserService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    public static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);

    private final Connection connection = PostgresConnectionHelper.getConnection();

    @Override
    public User get(String username) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM users where username = \'" + username + "\'";
            return executeQuery(statement, sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    private User executeQuery(Statement statement, String sql) {
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return new User(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("username"),
                        resultSet.getString("password")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<User> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM users";
            ResultSet resultSet = statement.executeQuery(sql);

            List<User> users = new ArrayList<>();

            while (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("username"),
                        resultSet.getString("password")
                );
                users.add(user);
            }

            return users;
        } catch (SQLException throwables) {
            LOGGER.warn("Failed execute getAll query.", throwables);
            return new ArrayList<>();
        }
    }

    @Override
    public void save(User user) {
        String sql = "INSERT INTO users (first_name, last_name, username, password) VALUES (?, ?, ?, ?);";
        User encryptUser = UserService.save(user);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, encryptUser.getFirstName());
            preparedStatement.setString(2, encryptUser.getLastName());
            preparedStatement.setString(3, encryptUser.getUsername());
            preparedStatement.setString(4, encryptUser.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            LOGGER.warn("Failed to save new user.", throwables);
        }
    }

    @Override
    public void changeFirstName(int id, String firstname) {
        String sql = "UPDATE users SET first_name = ? WHERE id = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, firstname);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void changeLastName(int id, String lastname) {
        String sql = "UPDATE users SET last_name = ? WHERE id = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1,lastname);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void changePassword(int id, String password) {
        String sql = "UPDATE users SET password = ? WHERE id = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1,password);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
