package ru.kpfu.itis.bagautdinov.service.impl;



import ru.kpfu.itis.bagautdinov.dao.Dao;
import ru.kpfu.itis.bagautdinov.dao.impl.UserDaoImpl;
import ru.kpfu.itis.bagautdinov.dto.UserDTO;
import ru.kpfu.itis.bagautdinov.helper.PasswordHelper;
import ru.kpfu.itis.bagautdinov.model.User;
import ru.kpfu.itis.bagautdinov.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {

    private final UserDaoImpl dao = new UserDaoImpl();

    @Override
    public UserDTO get(int id) {
        return null;
    }

    @Override
    public List<UserDTO> getAll() {
        List<User> users = dao.getAll();
        return users.stream()
                .map(u -> new UserDTO(u.getFirstName(), u.getLastName(), u.getLogin()))
                .collect(Collectors.toList());
    }

    @Override
    public void save(User user) {
        dao.save(new User(
                user.getFirstName(),
                user.getLastName(),
                user.getLogin(),
                PasswordHelper.encrypt(user.getPassword())
        ));
    }
}
