package com.example.demo.service;

import com.example.demo.dto.request.UserCreateRequest;
import com.example.demo.dto.response.UserCreateResponse;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public UserCreateResponse createUser (UserCreateRequest userCreateRequest){
        if(userRepo.existByUsername(userCreateRequest.getUsername()))
            throw new RuntimeException("Nguoi dung ton tai");

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        User user = User.builder()
                .username(userCreateRequest.getUsername())
                .password(passwordEncoder.encode(userCreateRequest.getPassword()))
                .build();
        userRepo.save(user);

        return UserCreateResponse.builder()
                .user(user.getUsername())
                .build();
    }
}
