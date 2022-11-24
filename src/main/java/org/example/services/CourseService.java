package org.example.services;

import org.example.Dao.CoursesDao;
import org.example.Dao.StudentDao;
import org.example.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    CoursesDao coursesDao;
    @Autowired
    public CourseService(CoursesDao coursesDao) {
        this.coursesDao = coursesDao;
    }



    public void delete(String courseName){
        coursesDao.deleteUserCourse(courseName);
    }
    public void updateName(String newCourseName,String oldCourseName) {
        coursesDao.updateUserCourseName(newCourseName,oldCourseName);
    }

    public void getPrint(int studentId){
        coursesDao.getPrintUserCourses(studentId);
    }

}
