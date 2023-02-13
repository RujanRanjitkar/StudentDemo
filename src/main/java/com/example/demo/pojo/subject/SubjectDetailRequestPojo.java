package com.example.demo.pojo.subject;

import com.example.demo.student.student;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Service
public class SubjectDetailRequestPojo {

    private Long subjectId;

    private String subject_name;

    private String teacher_name;

    private Long studentId;
}
