package by.work.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = "by.work")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(final HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/admin").hasAuthority("ADMIN")
                //.antMatchers("/home").hasAnyRole()
                .anyRequest().permitAll()
        .and()
        .formLogin()
            .loginPage("/login")
            .loginProcessingUrl("/login")
                .usernameParameter("user")
                .passwordParameter("pass")
                .defaultSuccessUrl("/home").
        and()
                .logout()
                .logoutUrl("logout");

    }
}