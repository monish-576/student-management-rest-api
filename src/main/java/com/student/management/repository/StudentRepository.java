package com.student.management.repository;

import com.student.management.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    /**
     * Retrieve all students enrolled in a specific course.
     *
     * @param course the name of the course
     * @return list of matching students
     */
    List<Student> findByCourse(String course);

    /**
     * Case-insensitive search for students enrolled in a course.
     *
     * @param course the name of the course
     * @return list of matching students
     */
    List<Student> findByCourseIgnoreCase(String course);
}
