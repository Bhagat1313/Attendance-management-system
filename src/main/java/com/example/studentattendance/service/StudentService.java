package com.example.studentattendance.service;

import com.example.studentattendance.model.Student;
import com.example.studentattendance.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service  // Marks this class as a service for business logic in the Spring context
public class StudentService {

    @Autowired  // Automatically injects an instance of the StudentRepository
    private StudentRepository studentRepository;

    // Method to retrieve all students from the repository
    public List<Student> getAllStudents() {
        return studentRepository.findAll();  // Calls findAll() method from MongoRepository
    }

    // Method to retrieve a specific student by their ID
    public Optional<Student> getStudentById(String id) {
        return studentRepository.findById(id);  // Calls findById() method from MongoRepository
    }

    // Method to add a new student to the database
    public Student addStudent(Student student) {
        return studentRepository.save(student);  // Saves the student object to the database
    }

    // Method to update an existing student's information
    public Student updateStudent(String id, Student studentDetails) {
        // First, check if the student exists by ID
        return studentRepository.findById(id).map(student -> {
            // If student exists, update their details
            student.setName(studentDetails.getName());
            student.setAge(studentDetails.getAge());
            student.setEmail(studentDetails.getEmail());
            student.setDepartment(studentDetails.getDepartment());
            // Save the updated student information to the repository
            return studentRepository.save(student);
        }).orElse(null);  // If no student is found with the given ID, return null
    }

    // Method to delete a student by their ID
    public boolean deleteStudent(String id) {
        // Check if student exists with the provided ID
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);  // Delete the student if found
            return true;  // Return true to indicate successful deletion
        }
        return false;  // Return false if the student with the given ID was not found
    }
}
