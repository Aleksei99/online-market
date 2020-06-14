package by.work.service;

import by.work.service.dto.UserDTO;

public interface UserService {
    UserDTO findById(Long id);
}
