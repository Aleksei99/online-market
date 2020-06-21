package by.work.database.repository;

import by.work.database.entity.PersonalInfo;
import by.work.database.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findUserById(Long id);
    User findByName(String name);
}
