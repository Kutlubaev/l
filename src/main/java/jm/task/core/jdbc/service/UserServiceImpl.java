package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import org.w3c.dom.ls.LSOutput;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    public void createUsersTable() {
        UserDaoJDBCImpl userDao = new UserDaoJDBCImpl();
        userDao.createUsersTable();
        System.out.println();
    }

    public void dropUsersTable() {
        UserDaoJDBCImpl userDao = new UserDaoJDBCImpl();
        userDao.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        UserDaoJDBCImpl userDao = new UserDaoJDBCImpl();
        userDao.saveUser(name, lastName, age);
        System.out.println("User с именем " + name + " добавлен в базу данных");
    }

    public void removeUserById(long id) {
        UserDaoJDBCImpl userDao = new UserDaoJDBCImpl();
        userDao.removeUserById(id);
        System.out.println("User с id " + id + " удален из базы данных");
    }

    public List<User> getAllUsers() {
        UserDaoJDBCImpl userDao = new UserDaoJDBCImpl();
        try {
            return userDao.getAllUsers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void cleanUsersTable() {
        UserDaoJDBCImpl userDao = new UserDaoJDBCImpl();
        userDao.cleanUsersTable();
    }
}
