package com.example.demo.service;

import com.example.demo.Repo.SubjectRepo;
import com.example.demo.Repo.studentRepo;
import com.example.demo.pojo.subject.SubjectDetailRequestPojo;
import com.example.demo.student.Subject;
import com.example.demo.student.student;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubjectService {
    private final SubjectRepo subjectRepo;
    private final ObjectMapper objectMapper;
    private final SubjectDetailRequestPojo subjectDetailRequestPojo;
    private final studentRepo studentRepo;

    public List<Subject> getService() {
        return subjectRepo.findAll();
    }

    public void addSubject(SubjectDetailRequestPojo subjectDetailRequestPojo) {
        Subject subject;
        student stud=studentRepo.findById(subjectDetailRequestPojo.getStudentId()).orElseThrow(() -> new IllegalArgumentException("Student does not exist by student id"));
        if(subjectDetailRequestPojo.getSubjectId()!=null)
            subject=subjectRepo.findById(subjectDetailRequestPojo.getSubjectId()).orElse(new Subject());
        subject=Subject
                .builder()
                .subjectId(subjectDetailRequestPojo.getSubjectId())
                .subject_name(subjectDetailRequestPojo.getSubject_name())
                .teacher_name(subjectDetailRequestPojo.getTeacher_name())
                .student(stud)
                .build();
        subjectRepo.save(subject);
    }

    public Optional<Subject> findStudentSubject(Long studentId) {
        return subjectRepo.findStudentSubject(studentId);
    }
}
