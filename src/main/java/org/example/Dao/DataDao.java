package org.example.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {
    @Autowired
    SessionFactory sessionFactory;
    public void updateUserData( String oldPhoneNumber,String newPhoneNumber){
        try(Session session=sessionFactory.openSession()){
            session.beginTransaction();
            int rowsAffected= session.createQuery("UPDATE Data set phoneNumber= :newPhoneNumber "  +
                            " where phoneNumber= :oldPhoneNumber").
                    setParameter("oldPhoneNumber",oldPhoneNumber)
                    .setParameter("newPhoneNumber",newPhoneNumber)
                    .executeUpdate();
            System.out.println(rowsAffected+" rowsAffected ");
            session.getTransaction().commit();
        }}
        public void deleteUserData( String phoneNumber){
            try(Session session=sessionFactory.openSession()){
                session.beginTransaction();
                int rowsAffected= session.createQuery("Delete from Data WHERE phoneNumber= :phoneNumber").
                        setParameter("phoneNumber",phoneNumber)
                        .executeUpdate();
                System.out.println(rowsAffected+" rowsAffected ");
                session.getTransaction().commit();
            }}

        //students.forEach(System.out::println);
    }

