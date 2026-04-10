package com.sml.controller;

import com.sml.model.User;
import com.sml.repository.UserRepository;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    // SIGNUP
    @PostMapping("/signup")
    public User signup(@RequestBody User user){
        return userRepository.save(user);
    }

    // LOGIN
    @PostMapping("/login")
    public User login(@RequestBody User user){

        Optional<User> dbUser = userRepository.findByEmail(user.getEmail());

        if(dbUser.isPresent() &&
                dbUser.get().getPassword().equals(user.getPassword())){

            return dbUser.get();

        }

        return null;
    }
}