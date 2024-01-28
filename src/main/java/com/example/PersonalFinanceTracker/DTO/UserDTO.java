package com.example.PersonalFinanceTracker.DTO;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UserDTO {

    private long id;
    private String login;
    @NotEmpty(message = "Name should not be empty")
    private String userName;
    @NotEmpty(message = "Password should not be empty")
    private String password;
    @NotEmpty(message = "Surname should not be empty")
    private String userSurname;
    @NotEmpty(message = "URL should not be empty")
    private String photoUrl;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
