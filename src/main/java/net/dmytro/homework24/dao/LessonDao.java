package net.dmytro.homework24.dao;

import net.dmytro.homework24.connection.DataBaseConnection;
import net.dmytro.homework24.entity.Homework;
import net.dmytro.homework24.entity.Lesson;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class LessonDao  {



    public List<Lesson> getAll() {
        String query = "SELECT * FROM Lesson JOIN Homework ON Lesson.homework_id = Homework.Id";

        List<Lesson> lessons = new ArrayList<>();

        try(Connection connection = DataBaseConnection.getConnection();
            Statement statement = connection.createStatement()){

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){

               Lesson lesson = Lesson.builder()
                        .id(resultSet.getLong("id"))
                        .name(resultSet.getString("name"))
                        .homework(Homework.builder().id(resultSet.getLong("id"))
                                .name(resultSet.getString("name"))
                                .description(resultSet.getString("description"))
                                .build())

                        .build();
                lessons.add(lesson);
            }

        }catch (SQLException ex){
            System.out.println(ex);
        }
        return lessons;

    }


    public Lesson get(Long id) {

        String query = "Select * FROM Lesson JOIN Homework ON Lesson.homework_id = Homework.id";

        try (Connection connection = DataBaseConnection.getConnection();
             Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                return Lesson.builder()
                        .id(resultSet.getLong("id"))
                        .name(resultSet.getString("id"))
                        .homework(Homework.builder()
                                .id(resultSet.getLong("id"))
                                .name(resultSet.getString("name"))
                                .description(resultSet.getString("description"))
                                .build())
                        .build();

            }

        }catch (SQLException e){
            System.out.println(e);
        }
        return null;

    }


    public void add(Lesson item)  {
        String query = "INSERT INTO Lesson (name, updateAt, homework_id) values (?, ?, ?)";

        try(Connection connection = DataBaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)){

            statement.setString(1, item.getName());
            statement.setString(2,"today");
            statement.setLong(3,item.getHomework().getId());

            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
    }


    public void delete(Long id) {
        String query = "DELETE FROM LESSON WHERE id = ?";

        try(Connection connection = DataBaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            statement.executeUpdate();

        }catch (SQLException ex){
            System.out.println(ex);
        }

    }
}
