package com.example.PersonalFinanceTracker.Service;

import com.example.PersonalFinanceTracker.DTO.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> findAllUsers();
}
