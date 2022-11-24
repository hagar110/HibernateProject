package org.example.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="course")
public class Course {
   public  Course(){}
    public Course(String name) {
        this.name = name;
        students=new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

   @Column(unique = true,nullable = false)
    private String name;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "courses")
   /* @JoinTable(name="student_courses",joinColumns=@JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name="student_id"))
*/
    private List<Student> students=new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
