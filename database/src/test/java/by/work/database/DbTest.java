package by.work.database;

import by.work.database.config.DaoConfig;
import by.work.database.entity.User;
import by.work.database.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DaoConfig.class)
public class DbTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findByIdTest() {
        Optional<User> user = userRepository.findUserById(1L);
        System.out.println(user.get());
    }
}
