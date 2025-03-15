package com.learn.spring_boot_jpa.repositories;

import com.learn.spring_boot_jpa.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Optional
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    // select * from author where first_name = 'Lalit';
    List<Author> findAllByFirstName(String firstName);

    // select * from author where first_name = 'LALIT';
    List<Author> findAllByFirstNameIgnoreCase(String firstName);

    // select * from author where first_name list '%ali%';
    List<Author> findAllByFirstNameContainingIgnoreCase(String firstName);

    // select * from author where first_name like 'Lal%'
    List<Author> findAllByFirstNameStartsWithIgnoreCase(String name);

    // select * from author where first_name like '%lit';
    List<Author> findAllByFirstNameEndsWithIgnoreCase(String name);

    // search * from author where first_name in ('lalit', 'lavik', 'sonu')
    List<Author> findAllByFirstNameInIgnoreCase(List<String> firstNames);
}
