package com.example.studentattendance.repository;

import com.example.studentattendance.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository  // Marks this interface as a repository for Spring Data MongoDB
public interface StudentRepository extends MongoRepository<Student, String> {

}
