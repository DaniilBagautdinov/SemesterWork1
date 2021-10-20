package ru.kpfu.itis.bagautdinov.service;

import ru.kpfu.itis.bagautdinov.helper.PasswordHelper;
import ru.kpfu.itis.bagautdinov.model.User;


public class UserService {

    public static User save(User user) {
        return new User(
                user.getFirstName(),
                user.getLastName(),
                user.getUsername(),
                PasswordHelper.encrypt(user.getPassword()));
    }
}
