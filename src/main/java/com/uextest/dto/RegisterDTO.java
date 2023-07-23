package com.uextest.dto;


import com.uextest.enums.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
