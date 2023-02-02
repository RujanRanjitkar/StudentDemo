package com.example.demo.service;

import com.example.demo.Repo.studentRepo;
import com.example.demo.student.student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class demoservice {
    private final studentRepo stdrepo;

    @Autowired
    public demoservice(studentRepo stdrepo) {
        this.stdrepo = stdrepo;
    }

    public List<student> getStudent(){
        return stdrepo.findAll();
    }

    public void addNewStudent(student st) {
        Optional<student> studentOptional = stdrepo.findstudentByEmail(st.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        stdrepo.save(st);
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
}
