package com.debarz.recipeapp.user.dto;

import com.debarz.recipeapp.user.model.Role;
import com.debarz.recipeapp.user.model.User;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
@Data
public class UserDTO {

    private Long id;

    @NotBlank
    @Size(min=3, max=20)
    private String username;

    @NotBlank
    @Size(min=3, max=20)
    private String lastName;

    @Size(min=3, max=20)
    private String name;

    private String email;

    private String phone;

    private Set<String> roles = new HashSet<>();

    public UserDTO(User user) {
        this.id = user.getId();
        this.username=user.getUsername();
        this.name=user.getName();
        this.lastName=user.getLastName();
        this.roles=user.getRoles().stream()
                .map(Role::getRoleName)
                .collect(Collectors.toSet());
    }
}
