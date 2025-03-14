package com.learn.spring_boot_jpa.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Section extends BaseEntity{
    private String name;
    private int sectionOrder;
    @ManyToOne
    @JoinColumn(
            name = "course_id"
    )
    @JsonBackReference
    private Course course;
    @OneToMany(
            mappedBy = "section",
            cascade = CascadeType.ALL
    )
    @JsonManagedReference
    private List<Lecture> lectures;
}
