package com.example.task.dto;

import com.example.task.model.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class UserDto {

    private Long id;
    private String login;
    private String name;
    private AccountType type;
    private String avatarUrl;
    private LocalDateTime createdAt;
    private double calculations;
}
