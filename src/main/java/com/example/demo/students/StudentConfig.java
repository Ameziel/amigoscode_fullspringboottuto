/*
 * StudentConfig.java
 */
package com.example.demo.students;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

/**
 * Class description goes here.
 *
 * @author Samuel Sicard
 * @version 0.9
 */
@Configuration
public class StudentConfig {

    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student mariam = new Student(
                    "Mariam",
                    "mariam@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 5)
            );
            Student jason = new Student(
                    "Jason",
                    "jasonm@gmail.com",
                    LocalDate.of(2004, Month.JANUARY, 5)
            );

            repository.saveAll(
                    List.of(mariam,jason)
            );
        };
    }

}
