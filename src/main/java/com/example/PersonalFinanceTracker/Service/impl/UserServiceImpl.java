package com.example.PersonalFinanceTracker.Service.impl;

import com.example.PersonalFinanceTracker.DTO.UserDTO;
import com.example.PersonalFinanceTracker.Model.User;
import com.example.PersonalFinanceTracker.Repository.UserRepository;
import com.example.PersonalFinanceTracker.Service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    private UserDTO mapToUserDTO(User user) {
        UserDTO userDTO = UserDTO.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .userSurname(user.getUserSurname())
                .photoUrl(user.getPhotoUrl())
                .createdOn(user.getCreatedOn())
                .updatedOn(user.getUpdatedOn())
                .build();
        return userDTO;
    }
}
