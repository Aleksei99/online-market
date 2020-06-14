package by.work.database.web;

import by.work.service.UserService;
import by.work.service.dto.UserDTO;
import by.work.web.config.WebConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = WebConfig.class)
public class WebTest {

    @Autowired
    private UserService userService;

    @Test
    public void shouldAnswerWithTrue()
    {
        UserDTO userDTO = userService.findById(1L);
        System.out.println(userDTO);
    }
}
