package com.example.demo.controller;

import com.example.demo.pojo.subject.SubjectDetailRequestPojo;
import com.example.demo.service.SubjectService;
import com.example.demo.student.Subject;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/subject")
@RequiredArgsConstructor
public class SubjectController {
    private final SubjectService subjectService;

    @GetMapping
    public List<Subject> getSubject(){
        return subjectService.getService();
    }

    @PostMapping
    public void registerNewSubject(@RequestBody SubjectDetailRequestPojo subjectDetailRequestPojo){
        subjectService.addSubject(subjectDetailRequestPojo);
    }
    @GetMapping("/{studentId}")
    public Optional<Subject> findStudentSubject(@PathVariable("studentId") Long studentId){
        return subjectService.findStudentSubject(studentId);
    }
}
