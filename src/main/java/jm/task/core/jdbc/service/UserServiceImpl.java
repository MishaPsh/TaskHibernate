package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao user_dao = new UserDaoHibernateImpl();

    @Override
    public void createUsersTable() {
        user_dao.createUsersTable();
    }

    @Override
    public void dropUsersTable() {
        user_dao.dropUsersTable();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        user_dao.saveUser(name, lastName, age);
    }

    @Override
    public void removeUserById(long id) {
        user_dao.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return user_dao.getAllUsers();
    }

    @Override
    public void cleanUsersTable() {
       user_dao.cleanUsersTable();
    }


//    private UserDao userDao = new UserDaoJDBCImpl();
//
//    public void createUsersTable() {
//        userDao.createUsersTable();
//    }
//
//    public void dropUsersTable() {
//        userDao.dropUsersTable();
//    }
//
//    public void saveUser(String name, String lastName, byte age) {
//        userDao.saveUser(name, lastName, age);
//    }
//
//    public void removeUserById(long id) { ;
//        userDao.removeUserById(id);
//    }
//
//    public List<User> getAllUsers() {
//        return userDao.getAllUsers();
//    }
//
//    public void cleanUsersTable() {
//        userDao.cleanUsersTable();
//    }
}
