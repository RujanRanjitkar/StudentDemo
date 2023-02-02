package com.example.demo.Repo;

import com.example.demo.student.student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface studentRepo extends JpaRepository<student, Long> {

    @Query("SELECT s FROM student s WHERE s.email=?1")
    Optional<student> findstudentByEmail(String email);
}
