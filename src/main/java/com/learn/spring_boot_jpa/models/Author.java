package com.learn.spring_boot_jpa.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@Table(name = "AUTHOR_TBL")
public class Author {
    // Primary-Key
    @Id
    @GeneratedValue
//    (
//           strategy = GenerationType.TABLE,
//           generator = "author_id_generator"
//    )

//    @SequenceGenerator(
//            name = "author_sequence",
//            sequenceName = "author_sequence",
//            allocationSize = 1
//    )

//    @TableGenerator(
//            name = "author_id_generator",
//            table = "id_generator",
//            pkColumnName = "id_name",
//            valueColumnName = "id_value",
//            allocationSize = 1
//    )
    private Integer id;
    @Column(
            length = 35
    )
    private String firstName;
    private String lastName;
    @Column(
            unique = true,
            nullable = false
    )
    private String email;
    private int age;
    @Column(
            updatable = false,
            nullable = false
    )
    private LocalDateTime createdAt;
    @Column(
            insertable = false
    )
    private LocalDateTime lastModifies;
}
