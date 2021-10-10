package ru.kpfu.itis.bagautdinov.service;



import ru.kpfu.itis.bagautdinov.dto.UserDTO;
import ru.kpfu.itis.bagautdinov.model.User;

import java.util.List;

public interface UserService {
    List<UserDTO> getAll();
    UserDTO get(int id);
    void save(User user);
}
