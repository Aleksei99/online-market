package by.work.service;

import by.work.service.config.ServiceConfig;
import by.work.service.dto.UserDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

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