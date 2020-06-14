package by.work.database.web;

import by.work.database.entity.User;
import by.work.service.UserServiceImpl;
import by.work.service.config.ServiceConfig;
import by.work.service.UserService;
import by.work.service.dto.UserDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ServiceConfig.class)
@ComponentScan(basePackages = {"by.work", "by.work.service"})

public class ServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void findByIdTest() {
        UserDTO user = userService.findById(1L);
        System.out.println(user);
    }
}
