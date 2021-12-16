/*
 * StudentRepository.java
 */
package com.example.demo.students;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/**
 * Class description goes here.
 *
 * @author Samuel Sicard
 * @version 0.9
 */
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);


}
