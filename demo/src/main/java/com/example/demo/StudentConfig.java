package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.util.Calendar.FEBRUARY;
import static java.util.Calendar.SEPTEMBER;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student hrishi = new Student(
                    "Hrishi",
                    "hrishikeshhedge0@gmail.com",
                    LocalDate.of(2000, FEBRUARY, 25));
            Student ashish = new Student(
                    "Ashish",
                    "ashishverma23@gmail.com",
                    LocalDate.of(2000, SEPTEMBER, 11));
            repository.saveAll(List.of(hrishi, ashish));
        };
    }
}
