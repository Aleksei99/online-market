package by.work.service;

import by.work.database.entity.Role;
import by.work.database.entity.User;
import by.work.database.repository.UserRepository;
import by.work.service.config.ServiceConfig;
import by.work.service.dto.UserDTO;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ServiceConfig.class)
@ComponentScan(basePackages = {"by.work", "by.work.service"})
@Transactional
public class UserServiceTest {
    private static final String FULL_NAME, NAME, SURNAME, PASSWORD;
    static {
        FULL_NAME = "Bob Marley";
        NAME = "Bob";
        SURNAME = "Marley";
        PASSWORD = "123";
    }

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;


    @Before
    public void beforeClass() throws Exception {
        User user = new User(NAME, SURNAME,NAME,PASSWORD, Role.SELLER);
        userRepository.save(user);
    }


    @Test
    public void findUserByIdTest() {
        Long id = userRepository.findAll().iterator().next().getId();
        UserDTO user = userService.findById(id);
        String actualFullName = user.getName() + " " + user.getSurname();

        Assert.assertNotNull(user);
        Assert.assertEquals(FULL_NAME, actualFullName);
    }

    @Test
    public void saveTest() {
        User user = new User("Eva", "Green","Eva","1234", Role.ADMIN);
        user.setId(2L);
        userService.save(user);

        Assert.assertNotNull(userService.findUserById(2L));
    }

    @Test
    public void loadUserByUserNameTest() {
        UserDetails user = userService.loadUserByUsername("Bob");

        Assert.assertNotNull(user);
        Assert.assertEquals(NAME, user.getUsername());
        Assert.assertEquals(PASSWORD, user.getPassword());
    }

    @Test
    public void UserNotFoundExceptionTest() {
        Throwable thrown = Assert.assertThrows(UsernameNotFoundException.class, () -> userService.loadUserByUsername("Mark"));
        String message = thrown.getMessage();
        Assert.assertNotNull(message);
        System.out.println(message);
    }
}