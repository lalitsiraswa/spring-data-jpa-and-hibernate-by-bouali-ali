package com.learn.spring_boot_jpa.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
// @Builder
@SuperBuilder
// When we use a builder within a child-class/derived-class, we are not able to access parent class fields,
// for this we need to use @SuperBuilder with all the entities that are inheriting from BaseEntity.
@Entity
//@Table(name = "AUTHOR_TBL")
public class Author extends BaseEntity {
    // Primary-Key
//    @Id
//    @GeneratedValue
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
//    private Integer id;
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
    //    @Column(
//            updatable = false,
//            nullable = false
//    )
//    private LocalDateTime createdAt;
//    @Column(
//            insertable = false
//    )
//    private LocalDateTime lastModifies;
    @ManyToMany(mappedBy = "authors")
    private List<Course> courses;
}
