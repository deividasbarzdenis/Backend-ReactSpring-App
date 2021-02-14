package com.debarz.recipeapp.user.controller;

import com.debarz.recipeapp.user.dto.UserDTO;
import com.debarz.recipeapp.user.model.User;
import com.debarz.recipeapp.user.service.UserService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@Api(tags = "responsibilities: for users interconnection")
public class UserController {

    private UserService userService;

    @PostMapping("/login")
    public UserDTO user(@AuthenticationPrincipal User user) {
        return new UserDTO(user);
    }

    @GetMapping("/api/users/{id}")
    public UserDTO getUser(@PathVariable long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/api/users")
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/api/users")
    public ResponseEntity<UserDTO> addUser(@RequestBody @Valid UserDTO userDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.createUser(userDTO));
    }

    @PostMapping("/api/users/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public UserDTO updateUser(@RequestBody @Valid UserDTO userDTO) {
        return userService.updateUser(userDTO);
    }

    @DeleteMapping("/api/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable long id){
        userService.deleteUser(id);
    }
}
