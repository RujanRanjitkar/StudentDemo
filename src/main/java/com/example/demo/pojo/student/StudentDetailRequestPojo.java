package com.example.demo.pojo.student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Service
public class StudentDetailRequestPojo {
    private Long studentId;

    private String name;

    private String email;

    private LocalDate dob;
}
