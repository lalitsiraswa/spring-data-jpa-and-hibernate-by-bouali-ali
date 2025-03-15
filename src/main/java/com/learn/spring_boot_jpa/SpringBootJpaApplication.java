package com.learn.spring_boot_jpa;

import com.learn.spring_boot_jpa.models.Video;
import com.learn.spring_boot_jpa.repositories.AuthorRepository;
import com.learn.spring_boot_jpa.repositories.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
//            var author = Author.builder()
//                    .firstName("Lavik")
//                    .lastName("Siraswa")
//                    .age(25)
//                    .email("lalitsiraswa@gmail.com")
////                    .createdAt(LocalDateTime.now())
//                    .build();
//            authorRepository.save(author);

            var video = Video.builder()
                    .name("smile.mp4")
                    .length(5)
                    .url("https://youtu.be/smile")
                    .build();
            videoRepository.save(video);
        };
    }
}
