package by.work.database.repository;

import by.work.database.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findUserById(Long id);

    User findById(Long id);

    User findByName(String name);

    User findByLogin(String login);
}
