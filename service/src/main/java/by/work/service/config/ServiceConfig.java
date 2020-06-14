package by.work.service.config;

import by.work.database.config.DaoConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {DaoConfig.class})
@ComponentScan(basePackages = {"by.work.service", "by.work.database"})
public class ServiceConfig {
}
