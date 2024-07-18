package lk.acpt.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String address;
    private double marks;
    @OneToMany
    @JoinColumn(name="student_id")
    private List<Subject> subjects;

    public Student(Integer studentId, String name, String address, double marks) {
        this.id = studentId;
        this.name = name;
        this.address = address;
        this.marks = marks;
    }

    public Student(String name, String address, double marks ) {
        this.name = name;
        this.address = address;
        this.marks = marks;
    }
}
