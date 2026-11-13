package com.student.management.service;

import com.student.management.entity.Student;

import java.util.List;

public interface StudentService {

    /**
     * Add and save a new student.
     *
     * @param student student entity to save
     * @return the saved student entity with generated ID
     */
    Student addStudent(Student student);

    /**
     * Retrieve all students.
     *
     * @return list of all students
     */
    List<Student> getAllStudents();

    /**
     * Retrieve a student by their unique ID.
     *
     * @param id student primary key
     * @return the student entity
     * @throws com.student.management.exception.StudentNotFoundException if not found
     */
    Student getStudentById(Long id);

    /**
     * Update an existing student's details.
     *
     * @param id student primary key
     * @param student updated student data
     * @return the updated student entity
     * @throws com.student.management.exception.StudentNotFoundException if not found
     */
    Student updateStudent(Long id, Student student);

    /**
     * Delete a student by their unique ID.
     *
     * @param id student primary key
     * @throws com.student.management.exception.StudentNotFoundException if not found
     */
    void deleteStudent(Long id);

    /**
     * Retrieve all students enrolled in a particular course.
     *
     * @param course the course name
     * @return list of students in the given course
     */
    List<Student> getStudentsByCourse(String course);
}
