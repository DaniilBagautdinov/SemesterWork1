package ru.kpfu.itis.bagautdinov.dao.impl;

import ru.kpfu.itis.bagautdinov.dao.LessonDao;
import ru.kpfu.itis.bagautdinov.helper.PostgresConnectionHelper;
import ru.kpfu.itis.bagautdinov.model.Lesson;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LessonDaoImpl implements LessonDao {

    private final Connection connection = PostgresConnectionHelper.getConnection();

    @Override
    public List<Lesson> getLessons() {
        List<Lesson> lessons = new ArrayList<>();
        try {
            String sql = "SELECT * FROM lessons";
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            while (resultSet.next()) {
                lessons.add(
                        new Lesson(resultSet.getInt("id"),
                                resultSet.getString("title"),
                                resultSet.getString("description"),
                                resultSet.getString("article"),
                                resultSet.getString("link"),
                                resultSet.getString("photo_title")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lessons;
    }
}
