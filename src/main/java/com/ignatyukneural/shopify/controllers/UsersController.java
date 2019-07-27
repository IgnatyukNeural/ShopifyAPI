package com.ignatyukneural.shopify.controllers;

import com.ignatyukneural.shopify.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UsersController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserDetailsService userDetailsService;

    @GetMapping("getallusers")
    public List getAll() {
        return userRepository.findAll();

    }

    @GetMapping("test")
    public List getTestData() {
        return (List) userDetailsService.loadUserByUsername("admin");
    }

}
