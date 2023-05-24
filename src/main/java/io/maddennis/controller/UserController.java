package io.maddennis.controller;

import io.maddennis.entity.User;
import io.maddennis.payload.UserCreateDto;
import io.maddennis.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @PostMapping(path = "/createUser", produces = "application/json")
    public ResponseEntity<User> createUser(@RequestBody UserCreateDto user) {
        User _user = new User(
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),user.getPassword(),
                user.getPhone()
        );
        return new ResponseEntity<>(userRepository.save(_user), HttpStatus.CREATED);
    }
}
