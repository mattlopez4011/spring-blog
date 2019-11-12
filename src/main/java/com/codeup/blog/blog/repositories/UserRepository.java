package com.codeup.blog.blog.repositories;

import com.codeup.blog.blog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
