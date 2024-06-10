package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.SessionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
//    Connection connection = Util.getConnection();

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
//        String sql = "CREATE TABLE IF NOT EXISTS users (id BIGINT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(45), lastName VARCHAR(45), age TINYINT)";
//        try(Statement statement = connection.createStatement()) {
//            statement.executeUpdate(sql);
//        } catch (SQLException e) {
//            System.err.println("Ошибка при создании таблицы" + e.getMessage());
//        }
    }

    public void dropUsersTable() {
//        String sql = "DROP TABLE IF EXISTS users";
//        try(Statement statement = connection.createStatement()) {
//            statement.executeUpdate(sql);
//        } catch (SQLException e) {
//            System.err.println("Ошибка при удалении таблицы" + e.getMessage());
//        }
    }

    public void saveUser(String name, String lastName, byte age) {
//        String sql = "INSERT INTO users (name, lastName, age) VALUES (?, ?, ?)";
//        try(PreparedStatement pst = connection.prepareStatement(sql)) {
//            pst.setString(1, name);
//            pst.setString(2, lastName);
//            pst.setInt(3, age);
//
//            pst.executeUpdate();
//        } catch (SQLException e) {
//            System.err.println("Ошибка при добавлении пользователя" + e.getMessage());
//        }
    }

    public void removeUserById(long id) {
//        String sql = "DELETE FROM users WHERE id = ?";
//        try (PreparedStatement pst = connection.prepareStatement(sql)) {
//            pst.setLong(1, id);
//            pst.executeUpdate();
//        } catch (SQLException e) {
//            System.err.println("Ошибка при удалении пользователя" + e.getMessage());
//        }
    }

    public List<User> getAllUsers()  {
//        List<User> users = new ArrayList<User>();
//        String sql = "SELECT * FROM users";
//        try (Statement statement = connection.createStatement()) {
//            ResultSet resultSet = statement.executeQuery(sql);
//            while (resultSet.next()) {
//                User user = new User();
//                user.setId(resultSet.getLong("id"));
//                user.setName(resultSet.getString("name"));
//                user.setLastName(resultSet.getString("lastName"));
//                user.setAge(resultSet.getByte("age"));
//                users.add(user);
//            }
//        } catch (SQLException e) {
//            System.err.println("Ошибка выводе пользователей" + e.getMessage());
//        }
        return null;
    }

    public void cleanUsersTable() {
//        String sql = "DELETE FROM users";
//        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//            preparedStatement.executeUpdate(sql);
//        } catch (SQLException e) {
//            System.err.println("Ошибка при удалении из таблицы всех" + e.getMessage());
//        }
    }
}
