package com.niroshan.backend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(encoderPWD());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/rest/**").fullyAuthenticated().and().httpBasic();
    }


    @Bean
    public BCryptPasswordEncoder encoderPWD(){
        return new BCryptPasswordEncoder();
    }

   /*
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.inMemoryAuthentication().withUser("niro").password("1234").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("niro1").password("12345").roles("USER");
    }

    */

    //security for all api
/*
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic();
    }

 */

    /*
    //security based on url
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/api/v1/**").fullyAuthenticated().and().httpBasic();
    }
     */

    //security based on role
/*
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/api/v1/**").hasAnyRole("ADMIN").anyRequest().fullyAuthenticated().and().httpBasic();
    }

    @Bean
    public static NoOpPasswordEncoder passwordEncoder(){
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

 */
}
