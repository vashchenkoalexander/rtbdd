package org.rtbdd.controller;

import jakarta.annotation.security.RolesAllowed;
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

import java.util.List;


@RestController
@RequestMapping(UserController.API_VERSION)
public class UserController {

    public static final String API_VERSION = "${api.version}" + "user";

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

    @GetMapping("/current")
    public User getCurrentUser(){
        return userService.getCurrentUser();
    }

    @GetMapping("/all")
    @RolesAllowed("ADMIN")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

}
