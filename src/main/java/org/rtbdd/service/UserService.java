package org.rtbdd.service;

import org.rtbdd.model.User;
import org.rtbdd.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    /**
     * method for create new user in system or update existed
     * @param user
     * @return exception or created user
     */
    public User create(User user){
        if(userRepository.existsByUsername(user.getUsername())){
            throw new RuntimeException("User with this username already exists");
        }

        if(userRepository.existsByEmail(user.getEmail())){
            throw new RuntimeException("User with this email already exists");
        }

        return save(user);
    }

    private User save(User user) {
        return userRepository.save(user);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public UserDetailsService getUserDetailsService() {
        return this::getUserByUsername;
    }

    public User getCurrentUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return getUserByUsername(username);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

}
