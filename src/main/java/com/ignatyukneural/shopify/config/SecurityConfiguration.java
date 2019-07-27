package com.ignatyukneural.shopify.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("testUser").password(encoder().encode("testpassword1234")).roles("USER")
                .and()
                .withUser("admin").password(encoder().encode("admintestpassword1234")).roles("ADMIN");
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    protected void configure(HttpSecurity security) throws Exception {
        security
                .headers().frameOptions().disable() //Make H2 console appear in the browser
                .and()
                .csrf().disable()
                .exceptionHandling()
                .and()
                .authorizeRequests()
                .antMatchers("api/v1/categories/**").permitAll()
                .antMatchers("api/v1/subcategories/**").permitAll()
                .antMatchers("api/v1/products/**").permitAll()
                .antMatchers("api/v1/users/**").hasRole("ADMIN")
                .antMatchers("api/v1/admin/**").hasRole("ADMIN");
    }

}
