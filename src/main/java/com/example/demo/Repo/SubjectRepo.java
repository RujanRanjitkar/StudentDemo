package com.example.demo.Repo;

import com.example.demo.student.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface SubjectRepo extends JpaRepository<Subject, Long> {

    @Query("SELECT subjectId,subject_name FROM Subject  WHERE student.studentId=?1")
    Optional<Subject> findStudentSubject(Long studentId);
}
