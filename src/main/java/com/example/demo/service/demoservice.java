package com.example.demo.service;

import com.example.demo.Repo.studentRepo;
import com.example.demo.pojo.student.StudentDetailRequestPojo;
import com.example.demo.student.student;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class demoservice{
    private final studentRepo stdrepo;
    private final ObjectMapper objectMapper;
    private final StudentDetailRequestPojo studentDetailRequestPojo;
//    private final StudentDetailMapper studentDetailMapper;



    public List<student> getStudent(){
        return stdrepo.findAll();
    }

    public void addNewStudent(StudentDetailRequestPojo studentDetailRequestPojo) {
        student std;
//        Optional<student> studentOptional = stdrepo.findstudentByEmail(st.getEmail());
//        if(studentOptional.isPresent()){
//            throw new IllegalStateException("email taken");
//        }
        if(studentDetailRequestPojo.getStudentId()!=null)
            std=stdrepo.findById(studentDetailRequestPojo.getStudentId()).orElse(new student());
        std=objectMapper.convertValue(studentDetailRequestPojo, student.class);
        stdrepo.save(std);
    }

    public void deleteStudent(Long studentId) {
        boolean exists=stdrepo.existsById(studentId);
        if(!exists){
            throw new IllegalStateException("student with id "+ studentId +" does not exists");
        }
        stdrepo.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        student stu=stdrepo.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "student with id " + studentId + " does not exist"
                ));
        if(name!=null && name.length()>0 && !Objects.equals(stu.getName(), name)){
            stu.setName(name);
        }
        if(email!=null && email.length()>0 && !Objects.equals(stu.getEmail(), email)){
            Optional<student> studentOptional=stdrepo.findstudentByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            stu.setEmail(email);
        }
    }

    public Optional<student> getStudentById(Long studentId) {
//        StudentDetailResponsePojo studentDetailResponsePojo = studentDetailMapper.getStudentById(studentId);
//        return studentDetailResponsePojo;

        boolean exists=stdrepo.existsById(studentId);
        if(!exists){
            throw new IllegalStateException("student with id "+ studentId +" does not exists");
        }
        return stdrepo.findById(studentId);
    }
}
