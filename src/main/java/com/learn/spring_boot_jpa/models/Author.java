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
    @GeneratedValue
    private Integer id;
    private String firstName;
    private String lastName;
    @Column(
            unique = true
    )
    private String email;
    private int age;
}
