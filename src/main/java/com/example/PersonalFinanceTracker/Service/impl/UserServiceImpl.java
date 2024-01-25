package com.example.PersonalFinanceTracker.Service.impl;

import com.example.PersonalFinanceTracker.DTO.UserDTO;
import com.example.PersonalFinanceTracker.Model.User;
import com.example.PersonalFinanceTracker.Repository.UserRepository;
import com.example.PersonalFinanceTracker.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    @Override
    public List<UserDTO> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(this::mapToUserDTO).collect(Collectors.toList());
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public UserDTO findById(long userId) {
        User user = userRepository.findById(userId).get();
        return mapToUserDTO(user);
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        User user = mapToUser(userDTO);
        userRepository.save(user);
    }

    private User mapToUser(UserDTO user) {
        return User.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .userSurname(user.getUserSurname())
                .photoUrl(user.getPhotoUrl())
                .build();
    }

    private UserDTO mapToUserDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .userSurname(user.getUserSurname())
                .photoUrl(user.getPhotoUrl())
                .createdOn(user.getCreatedOn())
                .updatedOn(user.getUpdatedOn())
                .build();
    }
}
