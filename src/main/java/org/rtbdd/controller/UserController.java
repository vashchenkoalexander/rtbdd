package org.rtbdd.controller;

import org.rtbdd.jwt.JwtAuthenticationResponse;
import org.rtbdd.jwt.LogInRequest;
import org.rtbdd.model.User;
import org.rtbdd.service.AuthService;
import org.rtbdd.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v0.1/user")
public class UserController {

    private final UserService userService;
    private final AuthService authService;

    public UserController(UserService userService, AuthService authService) {
        this.userService = userService;
        this.authService = authService;
    }

    @PostMapping("/register")
    public JwtAuthenticationResponse registerNewUser(@RequestBody User user) {
        return authService.createNewUser(user);
    }

    @PostMapping("/logIn")
    public JwtAuthenticationResponse logIn(@RequestBody LogInRequest request) {
        return authService.logIn(request);
    }

    @GetMapping("current")
    public User getCurrentUser(){
        return userService.getCurrentUser();
    }

}
