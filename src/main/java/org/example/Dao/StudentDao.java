package org.example.Dao;

import org.example.models.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class StudentDao {
    @Autowired
    SessionFactory sessionFactory;

    public void deleteUser( int studentId){
        try(Session session=sessionFactory.openSession()){
            session.beginTransaction();
            int rowsAffected= session.createQuery("Delete from Student WHERE id = :studentId").
                  setParameter("studentId",studentId)
                    .executeUpdate();
            System.out.println(rowsAffected+" rowsAffected ");
            session.getTransaction().commit();
        }}

    public void updateUserName( String newUserName,int studentId){
        try(Session session=sessionFactory.openSession()){
            session.beginTransaction();
        int rowsAffected= session.createQuery("UPDATE Student set full_name = :newUserName " + "WHERE id = :studentId").
                   setParameter("newUserName",newUserName).setParameter("studentId",studentId)
                   .executeUpdate();
            System.out.println(rowsAffected+" rowsAffected ");
            session.getTransaction().commit();
        }

        //students.forEach(System.out::println);
    }
    public void addStudentToDb(Student student){
        System.out.println("student.toString() = " + student.toString());
        try(Session session=sessionFactory.openSession()){
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
        }
    }
    public void getPrintStudents(){
        List<Student> students;
        try(Session session=sessionFactory.openSession()){
            session.beginTransaction();
            students=session.createQuery("from Student").list();
        }
        students.forEach(System.out::println);
    }
    public Student getPrintStudentByName( String name){
        Student student;
        try(Session session=sessionFactory.openSession()){
            session.beginTransaction();
            student= (Student) session.createQuery("from Student where full_name=:name").setParameter("name",name).list().get(0);

        }
        System.out.println(student.toString());
        return student;
    }
    }

