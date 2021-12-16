/*
 * StudentService.java
 */
package com.example.demo.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

/**
 * Class description goes here.
 *
 * @author Samuel Sicard
 * @version 0.9
 */
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(@RequestBody Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email already exist !");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        //studentRepository.deleteById(id);
        boolean exists = studentRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Studient with id " + id + "doesn't exists");
        }
        studentRepository.deleteById(id);
    }
}
