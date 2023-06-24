package net.dmytro.homework30.repository;

import net.dmytro.homework30.entity.Student;
import net.dmytro.homework30.enums.HibernateSession;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;

import java.util.List;

public class StudentRepository {

    public Student getById(Long id){
        try(Session session = HibernateSession.INSTANCE.openSession()){
            return session.get(Student.class,id);
        }
    }

    public List<Student> getAll(){
        try(Session session = HibernateSession.INSTANCE.openSession()) {
            HibernateCriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            JpaCriteriaQuery<Student> query = criteriaBuilder.createQuery(Student.class);
            query.from(Student.class);


            return session.createQuery(query).getResultList();

        }
    }
    public void insert(Student student){
        try(Session session = HibernateSession.INSTANCE.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(student);
            transaction.commit();

        }
    }
    public void update(Student student){
        try(Session session = HibernateSession.INSTANCE.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(student);
            transaction.commit();
        }
    }
    public void delete(Long id){
        try(Session session = HibernateSession.INSTANCE.openSession()){
            Transaction transaction = session.beginTransaction();
            session.delete(session.get(Student.class,id));
            transaction.commit();
        }
    }
}
