package com.debarz.recipeapp.user.dto;

import com.debarz.recipeapp.user.model.Role;
import com.debarz.recipeapp.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

    @Size(min=3, max=20)
    private String name;

    private String email;

    private String phone;

    private Set<String> roles = new HashSet<>();

    public UserDTO(User user) {
        this.id = user.getId();
        this.username=getUsername();
        this.lastName=getLastName();
        this.name=getName();
        this.email = getEmail();
        this.phone = getPhone();
        this.roles=user.getRoles().stream()
                .map(Role::getRoleName)
                .collect(Collectors.toSet());
    }
}
