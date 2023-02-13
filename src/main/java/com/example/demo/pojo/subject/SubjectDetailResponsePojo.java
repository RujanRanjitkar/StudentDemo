package com.example.demo.pojo.subject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Service
public class SubjectDetailResponsePojo {
    private Long subjectId;

    private String subject_name;

    private String teacher_name;

    private Long studentId;
}
