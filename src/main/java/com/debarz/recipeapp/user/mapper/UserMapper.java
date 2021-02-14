package com.debarz.recipeapp.user.mapper;

import com.debarz.recipeapp.user.dto.UserDTO;
import com.debarz.recipeapp.user.model.User;
import com.debarz.recipeapp.user.model.Role;
import com.debarz.recipeapp.user.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class UserMapper {

    private PasswordEncoder passwordEncoder;
    private RoleRepository roleRepository;

    public UserDTO convertUserToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setLastname(user.getLastname());
        userDTO.setEmail(user.getEmail());
        userDTO.setName(user.getName());
        userDTO.setPhone(user.getPhone());
        userDTO.setRoles(user.getRoles().stream()
                .map(Role::getRoleName)
                .collect(Collectors.toSet()));
        return userDTO;
    }

    public User convertUserDtoToUserEntity(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setLastname(userDTO.getLastname());
        user.setEmail(userDTO.getEmail());
        user.setName(userDTO.getName());
        user.setPhone(userDTO.getPhone());
        Role role = roleRepository.getOne(2L);
        user.addRole(role);
        return user;
    }
}
