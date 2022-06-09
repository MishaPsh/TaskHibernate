package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {
    }

    SessionFactory factory = Util.open_hibernate();

    @Override
    public void createUsersTable() {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.createSQLQuery("CREATE TABLE IF NOT EXISTS user(\n" +
                    "  id INT PRIMARY KEY AUTO_INCREMENT,\n" +
                    "  name VARCHAR(30),\n" +
                    "  lastName VARCHAR(30),\n" +
                    "  age INT\n" +
                    "  );").addEntity(User.class).executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Override
    public void dropUsersTable() {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.createSQLQuery("DROP TABLE IF EXISTS user").executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try (Session session = factory.openSession()) {
            User user = new User(name, lastName, age);
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        }
    }

    @Override
    public void removeUserById(long id) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            User user = session.get(User.class, id);
            session.delete(user);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List list_user;
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            list_user = session.createCriteria(User.class).list();
            session.getTransaction().commit();
        }
        return list_user;
    }

    @Override
    public void cleanUsersTable() {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.createSQLQuery("TRUNCATE TABLE user").executeUpdate();
            session.getTransaction().commit();
        }
    }
}
