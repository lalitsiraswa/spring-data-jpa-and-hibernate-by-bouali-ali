package com.learn.spring_boot_jpa.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Polymorphism;
import org.hibernate.annotations.PolymorphismType;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
// @PrimaryKeyJoinColumn(name = "video_id") -> It only works with the @Inheritance(strategy = InheritanceType.JOINED)
// @DiscriminatorValue(value = "V")
@Polymorphism(type = PolymorphismType.EXPLICIT)
public class Video extends Resource {
    private int length;
}
