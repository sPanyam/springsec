package com.example.demo;


import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Override
    protected  void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        authenticationManagerBuilder
                .inMemoryAuthentication()
                .withUser("Sai").password(encoder.encode("test123")).roles("USER").and()
                        .withUser("admin").password(encoder.encode("password123")).roles("ADMIN");


    }


    @Override
    protected  void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .authorizeRequests()
                .antMatchers("*/getTicket/over100").hasRole("USER")
//                .anyRequest()
//                .fullyAuthenticated()
                .and()
                .httpBasic();
        httpSecurity.csrf().disable();
        httpSecurity.cors().disable();
    }
}
