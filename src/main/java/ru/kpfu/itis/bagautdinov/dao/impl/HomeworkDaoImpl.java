package ru.kpfu.itis.bagautdinov.dao.impl;

import ru.kpfu.itis.bagautdinov.dao.HomeworkDao;
import ru.kpfu.itis.bagautdinov.helper.PostgresConnectionHelper;
import ru.kpfu.itis.bagautdinov.model.Homework;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HomeworkDaoImpl implements HomeworkDao {

    private final Connection connection = PostgresConnectionHelper.getConnection();

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
