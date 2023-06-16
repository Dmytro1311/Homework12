package net.dmytro.homework30;

import net.dmytro.homework30.entity.Student;
import net.dmytro.homework30.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class StudentRepositoryTest {
    StudentRepository repo = new StudentRepository();


    @Test
    public void addToDataBase(){
        Student student = Student.builder()
                .name("Barbossa")
                .email("StealShip@sparrow.com")
                .build();
        Student student2 = Student.builder()
                .name("Jack")
                .email("JackCapitan@sparrow.com")
                .build();
        Student student3 = Student.builder()
                .name("AnyBody")
                .email("ships@sparrow.com")
                .build();
        repo.insert(student);
        repo.insert(student2);
        repo.insert(student3);

    }
    @Test
    void getById(){
        Student student = repo.getById(5L);
        Assertions.assertEquals("AnyBody", student.getName());
    }

    @Test
    void getAll(){
        List<Student> studentList = repo.getAll();
        Assertions.assertTrue(studentList.size() >= 3);
    }

    @Test
    void updateTable(){
        Student student = repo.getById(3L);
        student.setName("Eliza");
        repo.update(student);
    }

    @Test
    void deleteFromTable(){
        repo.delete(4L);
    }
}
