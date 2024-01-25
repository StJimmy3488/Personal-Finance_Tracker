package com.example.PersonalFinanceTracker.Service;

import com.example.PersonalFinanceTracker.DTO.UserDTO;
import com.example.PersonalFinanceTracker.Model.User;

import java.util.List;

public interface UserService {
    List<UserDTO> findAllUsers();

    User saveUser(User user);

    UserDTO findById(long userId);

    void updateUser(UserDTO user);
}
