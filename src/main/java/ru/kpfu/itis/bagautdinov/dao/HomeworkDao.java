package ru.kpfu.itis.bagautdinov.dao;

import ru.kpfu.itis.bagautdinov.model.Homework;

import java.util.List;

public interface HomeworkDao {
    List<Homework> getHomeworks(int userId);
}
