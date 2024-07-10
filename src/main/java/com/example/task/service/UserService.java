package com.example.task.service;

import com.example.task.command.UserCommand;
import com.example.task.domain.User;
import com.example.task.dto.UserDto;
import com.example.task.exception.NumberCannotBeZeroException;
import com.example.task.exception.ObjectNullException;
import com.example.task.exception.UserNotFoundException;
import com.example.task.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RestTemplate restTemplate;

    @Value("${user.service.url}")
    private String url;
    @Value("${user.service.firstNumber}")
    private double firstNumber;
    @Value("${user.service.secondNumber}")
    private double secondNumber;
    @Value("${user.service.incrementValue}")
    private int incrementValue;


    public UserDto getUser(String login) {
        UserCommand command = fetchUserCommand(login);
        double calculations = performCalculations(command);
        saveUserOrIncrementRequestCount(login);
        return createUserDto(command, calculations);
    }

    private UserCommand fetchUserCommand(String login) {
        UserCommand command;
        try {
            command = restTemplate.getForObject(url + login, UserCommand.class);
        } catch (HttpClientErrorException e) {
            throw new UserNotFoundException(login);
        }
        if (command == null) {
            throw new ObjectNullException();
        }
        return command;
    }

    private double performCalculations(UserCommand command) {
        double followers = Double.parseDouble(command.getFollowers());
        if (followers == 0) {
            throw new NumberCannotBeZeroException();
        }
        double publicRepos = Double.parseDouble(command.getPublicRepos());
        return firstNumber / followers * (secondNumber + publicRepos);
    }

    private void saveUserOrIncrementRequestCount(String login) {
        User user = userRepository.findUserByLogin(login);
        if (user == null) {
            userRepository.save(createUser(login));
        } else {
            user.setRequestCount(user.getRequestCount() + incrementValue);
            userRepository.save(user);
        }
    }

    private User createUser(String login) {
        return User.builder()
                .login(login)
                .requestCount(incrementValue)
                .build();
    }

    private UserDto createUserDto(UserCommand command, double calculations) {
        return new UserDto(command.getId(), command.getLogin(), command.getName(),
                command.getType(), command.getAvatarUrl(), command.getCreatedAt(), calculations);
    }
}