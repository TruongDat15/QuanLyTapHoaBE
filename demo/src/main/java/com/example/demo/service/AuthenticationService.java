package com.example.demo.service;


import com.example.demo.dto.request.LoginRequest;
import com.example.demo.dto.response.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;

    public LoginResponse login(LoginRequest request){

        UsernamePasswordAuthenticationToken  authenticationToken= new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());

        Authentication authenticate = authenticationManager.authenticate(authenticationToken);

        // tra ve token

        return LoginResponse.builder()
                .accessToken("Acc123")
                .refreshToken("refresh123")
                .build();
    }
}
