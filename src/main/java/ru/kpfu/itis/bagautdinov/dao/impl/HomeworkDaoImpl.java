package ru.kpfu.itis.bagautdinov.dao.impl;

import ru.kpfu.itis.bagautdinov.dao.HomeworkDao;
import ru.kpfu.itis.bagautdinov.helper.PostgresConnectionHelper;
import ru.kpfu.itis.bagautdinov.model.Homework;
import ru.kpfu.itis.bagautdinov.service.HomeworkService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HomeworkDaoImpl implements HomeworkDao {

    private final Connection connection = PostgresConnectionHelper.getConnection();

    @Override
    public void createHomeworks(int userId) {
        String sql = "INSERT INTO homeworks (user_id, title, article) VALUES (?, ?, ?);";
        List<Homework> homeworks = HomeworkService.createHomeworks(userId);
        for (Homework homework : homeworks) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, homework.getUserId());
                preparedStatement.setString(2, homework.getTitle());
                preparedStatement.setString(3, homework.getArticle());
                preparedStatement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public List<Homework> getHomeworks(int userId) {

        List<Homework> homeworks = new ArrayList<>();
        try {
            String sql = "SELECT * FROM homeworks where user_id = \'" + userId + "\'";
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            while (resultSet.next()) {
                homeworks.add(
                        new Homework(resultSet.getInt("id"),
                                resultSet.getInt("user_id"),
                                resultSet.getString("title"),
                                resultSet.getString("article")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return homeworks;
    }
}
