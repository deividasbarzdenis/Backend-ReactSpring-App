package com.debarz.recipeapp.user.controller;

import com.debarz.recipeapp.user.dto.UserDTO;
import com.debarz.recipeapp.user.model.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController("/api")
public class LoginController {

    @PostMapping("/login")
    public UserDTO user(@AuthenticationPrincipal User user){
        return new UserDTO(user);
    }
}
