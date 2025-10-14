package com.example.demo.dto.response;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class UserCreateResponse {
    private String user;
}
