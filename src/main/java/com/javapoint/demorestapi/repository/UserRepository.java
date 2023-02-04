package com.javapoint.demorestapi.repository;

import com.javapoint.demorestapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
