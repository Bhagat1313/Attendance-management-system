package com.example.studentattendance.Controller;

import com.example.studentattendance.model.Student;
import com.example.studentattendance.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")  // This defines the base URL for all student-related endpoints
public class StudentController {

    @Autowired  // Injects the StudentService into the controller
    private StudentService studentService;

    // Endpoint to get all students from the database
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();  // Calls the service layer to fetch all students
    }

    // Endpoint to get a student by their unique ID
    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable String id) {
        return studentService.getStudentById(id);  // Calls the service to find a student by ID
    }

    // Endpoint to create a new student in the database
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);  // Passes the new student object to the service for saving
    }

    // Endpoint to update an existing student by their unique ID
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable String id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);  // Calls the service to update the student information
    }

    // Endpoint to delete a student by their unique ID
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable String id) {
        boolean isDeleted = studentService.deleteStudent(id);  // Calls the service to delete the student by ID
        return isDeleted ? "Student deleted successfully" : "Student not found";  // Returns a message based on success or failure
    }
}
