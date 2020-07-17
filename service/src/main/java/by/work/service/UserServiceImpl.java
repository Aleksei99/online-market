package by.work.service;

import by.work.database.entity.Role;
import by.work.database.entity.User;
import by.work.database.repository.UserRepository;
import by.work.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

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

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    private UserDTO convert(User user) {
        UserDTO result = new UserDTO();
        result.setName(user.getName());
        result.setSurname(user.getSurname());
        result.setRole(user.getRole().name());
        return result;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(username);
        Set<Role> roles = new HashSet<>();
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("User with username " + username + " not found");
        } else
            System.out.println("SUCCESS");
        roles.add(user.getRole());
        return new org.springframework.security.core.userdetails
                .User(user.getLogin(), user.getPassword(), convertRole(roles));

    }

    private Collection<? extends GrantedAuthority> convertRole(Set<Role> roles) {
        return roles
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.name()))
                .collect(Collectors.toSet());
    }


}

