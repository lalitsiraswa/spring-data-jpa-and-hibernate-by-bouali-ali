package com.learn.spring_boot_jpa;

import com.github.javafaker.Faker;
import com.learn.spring_boot_jpa.models.Author;
import com.learn.spring_boot_jpa.repositories.AuthorRepository;
import com.learn.spring_boot_jpa.repositories.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class SpringBootJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            AuthorRepository authorRepository,
            VideoRepository videoRepository
    ) {
        return args -> {
            for (int i = 1; i <= 50; i++) {
                Faker faker = new Faker();
                String firstName = faker.name().firstName();
                String lastName = faker.name().lastName();
                long days = faker.number().numberBetween(1, 50);
                var author = Author.builder()
                        .firstName(firstName)
                        .lastName(lastName)
                        .age(faker.number().numberBetween(20, 50))
                        .email(firstName.toLowerCase() + lastName.toLowerCase() + "@gmail.com")
                        .createdAt(LocalDateTime.now().minusDays(days))
                        .createdBy(firstName + " " + lastName)
                        .build();
                authorRepository.save(author);
            }

            /* var video = Video.builder()
                    .name("smile.mp4")
                    .length(5)
                    .url("https://youtu.be/smile")
                    .build();
            videoRepository.save(video); */

            // Update author with ID: 1
            var author = Author.builder()
                    .id(1)
                    .firstName("Lalit")
                    .lastName("Siraswa")
                    .age(25)
                    .email("lalitsiraswa@gmail.com")
                    .createdBy("Lalit Siraswa")
                    .createdAt(LocalDateTime.now())
                    .build();
//            authorRepository.save(author);

            // update author a set a.age = 25 where a.id = 1;
//            authorRepository.updateAuthor(25, 1);

            // update all authors age
//            authorRepository.updateAllAuthorsAges(39);

            // Find By @NamedQuery()
            var authors = authorRepository.findByNamedQuery(40);
            authors.forEach(System.out::println);
        };
    }
}
