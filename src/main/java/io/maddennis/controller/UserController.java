package io.maddennis.controller;

import io.maddennis.entity.User;
import io.maddennis.exception.ApiError;
import io.maddennis.exception.ResourceNotFoundException;
import io.maddennis.payload.UserCreateDto;
import io.maddennis.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

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

    @PutMapping(path = "/updateUser/{id}", produces = "application/json")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        User userDB = userRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + id + " does not exist"));

        userDB.setFirstName(user.getFirstName());
        userDB.setLastName(user.getLastName());
        userDB.setPhone(user.getPhone());
        userDB.setEmail(user.getEmail());
        userDB.setUsername(user.getFirstName().concat(user.getLastName()));

        return new ResponseEntity<>(userRepository.save(userDB),HttpStatus.CREATED);
    }

}
