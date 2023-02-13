package com.example.demo.controller;

import com.example.demo.pojo.student.StudentDetailRequestPojo;
import com.example.demo.service.demoservice;
import com.example.demo.student.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/student")
public class democontroller{
    private final demoservice demoService;

    @Autowired
    public democontroller(demoservice demoService) {
        this.demoService = demoService;
    }

    @GetMapping
    public List<student> getStudent(){
        return demoService.getStudent();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody StudentDetailRequestPojo studentDetailRequestPojo){
        demoService.addNewStudent(studentDetailRequestPojo);
    }

    @DeleteMapping(path="{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        demoService.deleteStudent(studentId);
    }

    @PutMapping( path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        demoService.updateStudent(studentId, name, email);
    }
    @GetMapping("/{studentId}")
    public Optional<student> getStudentById(@PathVariable("studentId") Long studentId) {
          return demoService.getStudentById(studentId);
    }

}
