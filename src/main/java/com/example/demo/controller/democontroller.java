package com.example.demo.controller;

import com.example.demo.service.demoservice;
import com.example.demo.student.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

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
    public void registerNewStudent(@RequestBody student std){
        demoService.addNewStudent(std);
    }

    @DeleteMapping(path="{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id){
        demoService.deleteStudent(id);
    }

    @PutMapping( path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        demoService.updateStudent(studentId, name, email);
    }

}
