package by.work.service;

import by.work.database.entity.User;
import by.work.service.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserDTO findById(Long id);

    User findUserById(Long id);

    User findByLogin(String login);

    void save(User user);
}
