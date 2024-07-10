package com.example.task.command;

import com.example.task.model.AccountType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class UserCommand {

    private Long id;
    private String login;
    private String name;
    private AccountType type;
    @JsonProperty("avatar_url")
    private String avatarUrl;
    @JsonProperty("created_at")
    private LocalDateTime createdAt;
    private String followers;
    @JsonProperty("public_repos")
    private String publicRepos;
}
