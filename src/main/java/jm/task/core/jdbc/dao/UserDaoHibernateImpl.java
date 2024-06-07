package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.sql.DriverManager;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private static final SessionFactory sessionFactory = Util.getSessionFactory();

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        String sql = "CREATE TABLE IF NOT EXISTS users (id BIGINT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(45), lastName VARCHAR(45), age TINYINT)";
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.createSQLQuery(sql).executeUpdate();
            transaction.commit();
        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
            System.err.println("Ошибка при создании таблицы" + e);
        }
    }

    @Override
    public void dropUsersTable() {
        String sql = "DROP TABLE IF EXISTS users";
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.createSQLQuery(sql).executeUpdate();
            transaction.commit();
        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
            System.err.println("Ошибка удалении таблицы" + e);
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        //Transaction transaction = null;
        User user = new User();
        user.setName(name);
        user.setLastName(lastName);
        user.setAge(age);
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
//            if (transaction != null) {
//               transaction.rollback();
//            }
            System.err.println("Ошибка при добавлении пользователя " + e);
        }

    }

    @Override
    public void removeUserById(long id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            User user = (User) session.get(User.class, id);
            session.delete(user);
            transaction.commit();
        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
            System.err.println("Ошибка при удалении пользователя по ID" + e);
        }
    }

    @Override
    public List<User> getAllUsers() {
        Transaction transaction = null;
        List<User> users = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            users = session.createQuery("from User").list();
            transaction.commit();
        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
            System.err.println("Ошибка при получении пользователей" + e);
        }
        return users;
    }

    @Override
    public void cleanUsersTable() {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.createSQLQuery("DELETE FROM users").executeUpdate();
            transaction.commit();
        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
            System.err.println("Ошибка при очистки таблицы" + e);
        }
    }
}
