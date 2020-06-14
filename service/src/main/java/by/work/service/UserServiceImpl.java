package by.work.service;

import by.work.database.entity.User;
import by.work.database.repository.UserRepository;
import by.work.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDTO findById(Long id) {
        return userRepository.findUserById(id)
                .map(this::convert)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    private UserDTO convert(User user) {
        UserDTO result = new UserDTO();
        result.setName(user.getName());
        result.setSurname(user.getSurname());
        result.setRole(user.getRole().name());
        return result;
    }
}

