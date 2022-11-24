package org.example.Dao;

import org.example.models.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;
@Repository
public class CoursesDao {
    @Autowired
    SessionFactory sessionFactory;
    public void deleteUserCourse( String courseName){
        try(Session session=sessionFactory.openSession()){
            session.beginTransaction();
            int rowsAffected= session.createQuery("Delete from Course WHERE name= :courseName").
                    setParameter("courseName",courseName)
                    .executeUpdate();
            System.out.println(rowsAffected+" rowsAffected ");
            session.getTransaction().commit();
        }}
    public void updateUserCourseName( String newCourseName,String courseName){
        try(Session session=sessionFactory.openSession()){
            session.beginTransaction();
            int rowsAffected= session.createQuery("UPDATE Course set name = :newCourseName " + "WHERE  name=:courseName").
                    setParameter("newCourseName",newCourseName).setParameter("courseName",courseName)
                    .executeUpdate();
            System.out.println(rowsAffected+" rowsAffected ");
            session.getTransaction().commit();
        }

    }

    public void getPrintUserCourses( int studentId){
      //  List<Course> studentCourses;
        List list;

        String course;
        try(Session session=sessionFactory.openSession()){
            session.beginTransaction();
            list=session.createQuery("select c.name , c.id FROM Course as c inner join c.students as s WHERE s.id=:studentId").setParameter("studentId",studentId).list();
         //   studentCourses=session.createQuery("from Course where student.id=:studentId").setParameter("studentId",studentId).list();
        }
        System.out.println("Student courses are :");
        Iterator<Object[]> iter = list.iterator();
        while (iter.hasNext()) {
            Object[] obj = iter.next();
            System.out.print(obj[0] + " ");
        }
     //  studentCourses.forEach(System.out::println);
    }

}
