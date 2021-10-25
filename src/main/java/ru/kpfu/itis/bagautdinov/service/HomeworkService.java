package ru.kpfu.itis.bagautdinov.service;

import ru.kpfu.itis.bagautdinov.model.Homework;

import java.util.ArrayList;
import java.util.List;

public class HomeworkService {

    public static List<Homework> createHomeworks(int userId) {
        List<Homework> homeworks = new ArrayList<>();
        homeworks.add(new Homework(userId,"Домашка по математике", "2+2=?"));
        homeworks.add(new Homework(userId,"Домашка по русскому языку", "Жи ши с какой буквой надо писать?"));
        homeworks.add(new Homework(userId,"Домашка по информатике", "Что такое мышка и для чего она нужна?"));
        return homeworks;
    }
}
