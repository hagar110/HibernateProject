package org.example;

import Configuration.AppConfig;
import org.example.models.Course;
import org.example.models.Data;
import org.example.models.Student;
import org.example.services.CourseService;
import org.example.services.DataService;
import org.example.services.StudentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);

        // assigning courses and data to students and saving in the database

       /* StudentService studentService=context.getBean(StudentService.class);
        Course physicsCourse=new Course("physicsCourse");
        Course mathCourse=new Course("MathCourse");
        Course chemistryCourse=new Course("chemistryCourse");
        Student student1=initStudent("Hagar","01120555020");
        Student student2=initStudent("Hadeer","01010101010");
        Assign2CoursesToStudents(student1,physicsCourse,chemistryCourse);
        Assign1CourseToStudents(student2,mathCourse);
        studentService.addStudentToDb(student2);
        studentService.addStudentToDb(student1);
        studentService.getPrintStudents();
      */

        // operations on students courses

        /*CourseService courseService=context.getBean(CourseService.class);
        courseService.delete("MathCourse");
        courseService.getPrint(2);
        courseService.updateName("physicsNewCourse","physicsCourse");
         */
        //Operations on students data

       /* DataService dataService=context.getBean(DataService.class);
         dataService.updateData("011111111","01120555020");
         dataService.deleteData("011111111");
        */
}
private static void  Assign2CoursesToStudents(Student student1,Course physicsCourse,Course chemistryCourse){
    physicsCourse.getStudents().add(student1);
    chemistryCourse.getStudents().add(student1);
    student1.getCourses().add(chemistryCourse);
    student1.getCourses().add(physicsCourse);
    }
    private static void  Assign1CourseToStudents(Student student2,Course physicsCourse){
        physicsCourse.getStudents().add(student2);
        student2.getCourses().add(physicsCourse);

    }
private static Student initStudent(String userName,String phoneNumber){
    Student student=new Student();
    student.setName(userName);
    Data data=new Data();
    data.setPhoneNumber(phoneNumber);
    data.setStudent(student);
    student.getData().add(data);
    return student;
}

}