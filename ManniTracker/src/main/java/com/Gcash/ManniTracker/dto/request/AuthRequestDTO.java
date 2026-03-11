package com.Gcash.ManniTracker.dto.request;

import lombok.Data;

@Data
public class AuthRequestDTO {
    private String email;
    private String password;
    private String fullName;
}