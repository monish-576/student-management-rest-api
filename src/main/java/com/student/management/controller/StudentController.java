package com.student.management.controller;

import com.student.management.entity.Student;
import com.student.management.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    // Constructor injection
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * 1. POST /api/students
     * Add a new student.
     * Status Code: 201 Created
     */
    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student savedStudent = studentService.addStudent(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    /**
     * 2. GET /api/students
     * Retrieve all students.
     * Status Code: 200 OK
     */
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    /**
     * 3. GET /api/students/{id}
     * Retrieve student by ID.
     * Status Code: 200 OK (or 404 if not found)
     */
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        return ResponseEntity.ok(student);
    }

    /**
     * 4. PUT /api/students/{id}
     * Update existing student details.
     * Status Code: 200 OK (or 404 if not found)
     */
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(id, student);
        return ResponseEntity.ok(updatedStudent);
    }

    /**
     * 5. DELETE /api/students/{id}
     * Delete a student by ID.
     * Status Code: 200 OK (or 404 if not found)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Student deleted successfully with ID: " + id);
        return ResponseEntity.ok(response);
    }

    /**
     * 6. GET /api/students/course/{course}
     * Retrieve students belonging to a particular course.
     * Status Code: 200 OK
     */
    @GetMapping("/course/{course}")
    public ResponseEntity<List<Student>> getStudentsByCourse(@PathVariable String course) {
        List<Student> students = studentService.getStudentsByCourse(course);
        return ResponseEntity.ok(students);
    }
}

