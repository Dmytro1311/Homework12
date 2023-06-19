package net.dmytro.homework30.enums;

import net.dmytro.homework30.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public enum HibernateSession {
    INSTANCE;

    private  SessionFactory sessionFactory;


    HibernateSession(){
        sessionFactory = new Configuration().configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
    }

    public Session openSession(){
        return sessionFactory.openSession();
    }


}
