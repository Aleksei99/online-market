package by.work.database.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@EnableTransactionManagement
@Configuration
@PropertySource("classpath:config.properties")
@EnableJpaRepositories(basePackages = "by.work.database")
@ComponentScan(basePackages = {"by.work"})
public class DaoConfig {
    @Value("${database.url}")
    private String url;

    @Value("${database.driver}")
    private String driver;

    @Value("${database.user}")
    private String user;

    @Value("${database.password}")
    private String password;

    @Value("${hibernate.dialect}")
    private String dialect;

    @Value("${hibernate.show_sql}")
    private String show_sql;

    @Value("${hibernate.format_sql}")
    private String format_sql;

    @Value("${hibernate.creation_policy}")
    private String creation_policy;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driver);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("by.work.database.entity");
        factory.setDataSource(dataSource());
        factory.setJpaProperties(getHibernateProperties());
        return factory;
    }

    @Bean
    public Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect",dialect);
        properties.setProperty("hibernate.show_sql",show_sql);
        properties.setProperty("hibernate.format_sql",format_sql);
        properties.setProperty("hibernate.creation_policy",creation_policy);
        return properties;
    }
    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
}
