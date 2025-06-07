package org.rtbdd.service;

import org.rtbdd.jwt.JwtAuthenticationResponse;
import org.rtbdd.jwt.LogInRequest;
import org.rtbdd.model.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class AuthService {

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public AuthService(JwtService jwtService, AuthenticationManager authenticationManager, UserService userService, PasswordEncoder passwordEncoder) {
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Регистрация пользователя
     *
     * @param user данные пользователя
     * @return токен
     */
    public JwtAuthenticationResponse createNewUser(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreatedAt(LocalDateTime.now());

        userService.create(user);

        var jwt = jwtService.generateToken(user);
        return new JwtAuthenticationResponse(jwt);
    }

    public JwtAuthenticationResponse logIn(LogInRequest request) {
        try {
            // Attempt authentication
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    request.getUsername(),
                    request.getPassword()
            ));
        } catch (BadCredentialsException e) {
            // Handle incorrect credentials
            throw new BadCredentialsException("Invalid username or password");
        }

        // Load user details after successful authentication
        var user = userService
                .getUserDetailsService()
                .loadUserByUsername(request.getUsername());

        // Generate JWT token
        var jwt = jwtService.generateToken(user);
        return new JwtAuthenticationResponse(jwt);

    }
}
