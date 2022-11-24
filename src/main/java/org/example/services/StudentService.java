package org.example.services;

import org.example.Dao.StudentDao;
import org.example.models.Course;
import org.example.models.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
   StudentDao studentDao;
    @Autowired
    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
    public void delete(int studentId){
         studentDao.deleteUser(studentId);
    }
    public void updateName(String newUserName,int studentId) {
        studentDao.updateUserName(newUserName, studentId);
    }
    public void addStudentToDb(Student student){
       studentDao.addStudentToDb(student);
    }
    public void getPrintStudents(){
       studentDao.getPrintStudents();
    }
    public Student getPrintStudentByName(String studentName){
      return studentDao.getPrintStudentByName(studentName);
}
}
