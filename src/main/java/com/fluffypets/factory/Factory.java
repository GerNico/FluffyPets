package com.fluffypets.factory;

import exeptions.DAOException;
import com.fluffypets.DAO.category.CategoryDAO;
import com.fluffypets.DAO.category.CategoryDAOImpl;
import com.fluffypets.DAO.product.ProductDAO;
import com.fluffypets.DAO.product.ProductDAOImpl;
import com.fluffypets.DAO.user.UserDAO;
import com.fluffypets.DAO.user.UserDAOImpl;
import com.fluffypets.MVC.controller.Controller;
import com.fluffypets.MVC.controller.CreateUserController;
import com.fluffypets.servicies.UserService;
import com.fluffypets.servicies.UserServiceImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Factory {

    private static Connection getConnectionH2() {
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new DAOException("problem with JDBC H2 driver");
        }
        return connection;
    }

    private static Connection getConnectionMySQL() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pets",
                    "root", "nicolas");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new DAOException("problem with JDBC MySQL driver");
        }
        return connection;
    }

    private static UserService getUserService(UserDAO userDao) {
        return new UserServiceImpl(userDao);
    }
    public static Controller createUserController(Class<CreateUserController> createUserControllerClass) {
        return null;
    }

    public static UserDAO getUserDao() { return new UserDAOImpl(Factory.getConnectionMySQL());}

    public static CategoryDAO getCategoryDao() {return new CategoryDAOImpl(Factory.getConnectionMySQL());}

    public static ProductDAO getProductDao() {return new ProductDAOImpl(Factory.getConnectionMySQL());}

    public static CategoryDAO categoryDaoByConnection(Connection connection) {return new CategoryDAOImpl(connection);}

}
