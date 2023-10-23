package com.example.PersonalFinanceTracker.Repository;

import com.example.PersonalFinanceTracker.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByUserName(String name);
}
