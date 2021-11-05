package com.example.BlogAppSpring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // TODO authorize

        http.
                csrf().disable()
                .formLogin()
                .and()
                .authorizeRequests()
                .antMatchers("/users").hasAnyAuthority("ADMIN")
                .antMatchers("/register").permitAll()
                .antMatchers("/blogs").authenticated()
                .antMatchers("/blog-write").hasAnyAuthority("USER", "ADMIN","MODERATOR");

    }
}
