package com.example.studentattendance.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "students")  // Marks this class as a MongoDB document, specifying the "students" collection in the database
public class Student {

    @Id  // Marks the id field as the primary key in the MongoDB collection
    private String id;

    private String name;  // Field for storing student's name
    private int age;  // Field for storing student's age
    private String email;  // Field for storing student's email
    private String department;  // Field for storing student's department

    // Default constructor for creating an empty Student object
    public Student() {}

    // Parameterized constructor to initialize a Student object with specific values
    public Student(String name, int age, String email, String department) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.department = department;
    }

    // Getter and setter methods for each field

    public String getId() {
        return id;  // Returns the student's unique ID
    }

    public String getName() {
        return name;  // Returns the student's name
    }

    public void setName(String name) {
        this.name = name;  // Sets the student's name
    }

    public int getAge() {
        return age;  // Returns the student's age
    }

    public void setAge(int age) {
        this.age = age;  // Sets the student's age
    }

    public String getEmail() {
        return email;  // Returns the student's email
    }

    public void setEmail(String email) {
        this.email = email;  // Sets the student's email
    }

    public String getDepartment() {
        return department;  // Returns the student's department
    }

    public void setDepartment(String department) {
        this.department = department;  // Sets the student's department
    }
}
