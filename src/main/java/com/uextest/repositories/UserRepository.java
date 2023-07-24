package com.uextest.repositories;

import com.uextest.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, String> {
    UserDetails findByLogin(String login);

    @Query("SELECT u FROM User u WHERE u.id = :userId")
    User findByUserId(Long userId);
}
