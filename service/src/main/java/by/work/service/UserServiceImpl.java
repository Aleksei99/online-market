package by.work.service;

import by.work.database.entity.PersonalInfo;
import by.work.database.entity.Role;
import by.work.database.entity.User;
import by.work.database.repository.PersonalInfoRepository;
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
    private final PersonalInfoRepository personalInfoRepository;

    @Autowired
    public UserServiceImpl(final UserRepository userRepository, final PersonalInfoRepository personalInfoRepository) {
        this.userRepository = userRepository;
        this.personalInfoRepository=personalInfoRepository;
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        PersonalInfo personalInfo = personalInfoRepository.findByLogin(username);
        Set<Role> roles = new HashSet<>();
        if (Objects.isNull(personalInfo)) {
            throw new UsernameNotFoundException("User with username " + username + " not found");
        }else
            System.out.println("SUCCESS");
            roles.add(personalInfo.getUser().getRole());
            return new org.springframework.security.core.userdetails
                    .User(personalInfo.getUser().getName(), personalInfo.getPassword(), convertRole(roles));

    }

    private Collection<? extends GrantedAuthority> convertRole(Set<Role> roles) {
        return roles
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.name()))
                .collect(Collectors.toSet());
    }


}

