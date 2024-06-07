package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import org.w3c.dom.ls.LSOutput;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    //UserDao userDao = new UserDaoJDBCImpl();
    UserDao userDaoHibernate = new UserDaoHibernateImpl();
    public void createUsersTable() {
        userDaoHibernate.createUsersTable();
    }

    public void dropUsersTable() {
        userDaoHibernate.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        userDaoHibernate.saveUser(name, lastName, age);
        System.out.println("User с именем " + name + " добавлен в базу данных");
    }

    public void removeUserById(long id) {
        userDaoHibernate.removeUserById(id);
        System.out.println("User с id " + id + " удален из базы данных");
    }

    public List<User> getAllUsers() {
        try {
            return userDaoHibernate.getAllUsers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void cleanUsersTable() {
        userDaoHibernate.cleanUsersTable();
    }
}
