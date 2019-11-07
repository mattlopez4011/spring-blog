package com.codeup.blog.blog.repositories;

import com.codeup.blog.blog.models.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogRepository extends JpaRepository<Dog, Long> {

}
