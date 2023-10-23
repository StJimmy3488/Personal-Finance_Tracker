package com.example.PersonalFinanceTracker.DTO;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Builder
public class UserDTO {

    private int id;
    private String login;
    private String userName;
    private String userSurname;
    private String photoUrl;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
