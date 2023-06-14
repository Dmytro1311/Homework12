package net.dmytro.homework24;

import lombok.SneakyThrows;
import net.dmytro.homework24.dao.LessonDao;
import net.dmytro.homework24.entity.Homework;
import net.dmytro.homework24.entity.Lesson;
import org.junit.jupiter.api.Test;

public class LessonDaoTest {

    @Test
    @SneakyThrows
    void addTest() {
        Lesson lesson = Lesson.builder()
                .name("I'm added to sql!")
                .homework(Homework.
                        builder()
                        .id(2)
                        .build())
                .build();

        new LessonDao().add(lesson);
    }
    @Test
    @SneakyThrows
    void getAllTest(){
        new LessonDao().getAll()
                .forEach(System.out::println);
    }
    @Test
    @SneakyThrows
    void getTest(){
        System.out.println(new LessonDao().get(1L));
    }
    @Test
    @SneakyThrows
    void deleteTest(){
        new LessonDao().delete(1L);
    }
}
