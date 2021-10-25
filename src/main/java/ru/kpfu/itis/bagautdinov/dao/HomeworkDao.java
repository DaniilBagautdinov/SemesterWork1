package ru.kpfu.itis.bagautdinov.dao;

import ru.kpfu.itis.bagautdinov.model.Homework;

import java.util.List;

public interface HomeworkDao {
    void createHomeworks(int userId);

    List<Homework> getHomeworks(int userId);
}
