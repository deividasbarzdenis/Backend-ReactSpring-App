package com.debarz.recipeapp.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserDTO {

    private Long id;

    @NotBlank
    @Size(min=3, max=20)
    private String username;

    @NotBlank
    @Size(min=3, max=20)
    private String lastName;

    private String password;

    @Size(min=3, max=20)
    private String name;

    private String email;

    private String phone;

}
