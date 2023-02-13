package com.example.demo.student;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Data
@Table(name="subject")
public class Subject {
    @Id
    @SequenceGenerator(
            name="subject_sequence",
            sequenceName="subject_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "subject_sequence"
    )
    @Column(name="subject_id")
    private Long subjectId;

    @Column(name="subject_name")
    private String subject_name;

    @Column(name="teacher_name")
    private String teacher_name;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="student_id")

    @ManyToOne(targetEntity = student.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", referencedColumnName = "student_id", foreignKey = @ForeignKey(name = "FK_subject_student"))
    private  student student;
}
