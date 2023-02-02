package com.example.demo.config;

import com.example.demo.Repo.studentRepo;
import com.example.demo.student.student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(studentRepo repo){
        return args -> {
            student rujan= new student(
                    "Rujan",
                    "rujan@gmail.com",
                    LocalDate.of(2000, JANUARY,5)
            );

            student badsna= new student(
                    "Badsna",
                    "badsna@gmail.com",
                    LocalDate.of(2001, JANUARY,5)
            );

            repo.saveAll(
                    List.of(rujan,badsna)
            );
        };
    }
}
