package Configuration;

import org.example.models.Course;
import org.example.models.Data;
import org.example.models.Student;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example")
public class AppConfig {
    @Bean
 SessionFactory getSessionFactory(){
     return new org.hibernate.cfg.Configuration().configure("hibernate.cfg.xml").
             addAnnotatedClass(Data.class). addAnnotatedClass(Student.class).addAnnotatedClass(Course.class)
             .buildSessionFactory();
 }
}
