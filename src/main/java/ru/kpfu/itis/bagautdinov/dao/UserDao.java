package ru.kpfu.itis.bagautdinov.dao;

import ru.kpfu.itis.bagautdinov.model.User;

import java.util.List;

public interface UserDao {

    User get(String username);

    List<User> getAll();

    void save(User user);
}
