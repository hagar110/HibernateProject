package org.example.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Data {
    @Column(unique = true)
    private String phoneNumber;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @JoinColumn(name = "student_id")
    @ManyToOne
    private Student student;

    public Data() {
        student=new Student();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Data{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", id=" + id +

                '}';
    }
}
