package com.debarz.recipeapp.user.service;

import com.debarz.recipeapp.user.dto.UserDTO;
import com.debarz.recipeapp.user.exception.EntityNotFoundException;
import com.debarz.recipeapp.user.mapper.UserMapper;
import com.debarz.recipeapp.user.model.User;
import com.debarz.recipeapp.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserDTO createUser(UserDTO userDTO){
        User user = userMapper.convertUserDtoToUserEntity(userDTO);
        User saveUser = userRepository.save(user);
        userDTO.setId(saveUser.getId());
        return userDTO;
    }

    public UserDTO getUserById(long id) {
        User user = getById(id);
        return userMapper.convertUserToDTO(user);
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> userMapper.convertUserToDTO(user))
                .collect(Collectors.toList());
    }

    public UserDTO updateUser(UserDTO userDTO) {
        Long id = userDTO.getId();
        if(id == null){
            throw new EntityNotFoundException(id);
        }
        User user = getById(id);
        BeanUtils.copyProperties(userDTO, user);
        userRepository.save(user);
        return userDTO;
    }

    private User getById(long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id));
    }

    public void deleteUser(long id) {
        if(!userRepository.existsById(id)){
            throw new EntityNotFoundException(id);
        }
        userRepository.deleteById(id);
    }
}
