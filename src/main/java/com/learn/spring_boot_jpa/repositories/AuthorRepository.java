package com.learn.spring_boot_jpa.repositories;

import com.learn.spring_boot_jpa.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
