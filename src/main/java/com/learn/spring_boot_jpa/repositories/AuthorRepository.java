package com.learn.spring_boot_jpa.repositories;

import com.learn.spring_boot_jpa.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Optional
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    List<Author> findAllByFirstName(String firstName);

    List<Author> findAllByFirstNameIgnoreCase(String firstName);
}
