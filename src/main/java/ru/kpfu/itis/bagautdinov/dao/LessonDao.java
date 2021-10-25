package ru.kpfu.itis.bagautdinov.dao;

import ru.kpfu.itis.bagautdinov.model.Lesson;

import java.util.List;

public interface LessonDao {
    List<Lesson> getLessons();
}
