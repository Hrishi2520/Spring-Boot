package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {

    @Autowired
    private final StudentSevice studentSevice;

    public StudentController(StudentSevice studentSevice) {
        this.studentSevice = studentSevice;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentSevice.getStudents();
    }
    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentSevice.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id) {
        studentSevice.deleteStudent(id);
    }

    @PutMapping(path = "{studentId}")
    public void putStudent(@PathVariable("studentId") Long id,
                           @RequestParam(required = false) String name,
                           @RequestParam(required = false) String email) {
        studentSevice.updateStudent(id, name, email);
    }
}
