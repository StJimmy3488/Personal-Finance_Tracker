package com.example.PersonalFinanceTracker.DTO;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UserDTO {

    private long id;
    private String login;
    private String userName;
    private String password;
    private String userSurname;
    private String photoUrl;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
