package by.work.service;

import by.work.service.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService{
    UserDTO findById(Long id);
}
