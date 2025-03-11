package com.learn.spring_boot_jpa.models;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Author {
    // Primary-Key
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "author_sequence"
    )
    @SequenceGenerator(
            name = "author_sequence",
            sequenceName = "author_sequence",
            allocationSize = 1
    )
    private Integer id;
    private String firstName;
    private String lastName;
    @Column(
            unique = true
    )
    private String email;
    private int age;
}
