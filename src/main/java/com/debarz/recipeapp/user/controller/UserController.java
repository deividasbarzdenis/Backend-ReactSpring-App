package com.debarz.recipeapp.user.controller;

import com.debarz.recipeapp.user.dto.UserDTO;
import com.debarz.recipeapp.user.model.User;
import com.debarz.recipeapp.user.service.UserService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
@Api(tags = "responsibilities: for users interconnection")
public class UserController {

    private UserService userService;

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable long id) {
        return userService.getUserById(id);
    }

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public ResponseEntity<UserDTO> addUser(@RequestBody @Valid User user) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.createUser(user));
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public UserDTO updateUser(@RequestBody @Valid UserDTO userDTO) {
        return userService.updateUser(userDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable long id){
        userService.deleteUser(id);
    }
}
