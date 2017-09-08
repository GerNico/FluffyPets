package com.fluffypets.factory;

import com.fluffypets.DAO.category.CategoryDAO;
import com.fluffypets.DAO.category.CategoryDAOImpl;
import com.fluffypets.DAO.orders.OrderDAO;
import com.fluffypets.DAO.orders.OrderDAOImpl;
import com.fluffypets.DAO.orders.OrderItemDAO;
import com.fluffypets.DAO.orders.OrderItemDAOImpl;
import com.fluffypets.DAO.product.ProductDAO;
import com.fluffypets.DAO.product.ProductDAOImpl;
import com.fluffypets.DAO.user.UserDAOImpl;
import com.fluffypets.DAO.user.UserDataDAOImpl;
import com.fluffypets.MVC.controller.Controller;
import com.fluffypets.MVC.controller.UploadPhotoController;
import com.fluffypets.MVC.controller.pages.*;
import com.fluffypets.MVC.controller.post.*;
import com.fluffypets.MVC.servlets.ViewModel;
import com.fluffypets.servicies.*;
import exeptions.DAOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Factory {
    private static ViewModel vm = new ViewModel();

    public static Connection getConnection() {
        return Factory.getConnectionMySQL();
    }

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

    public static ViewModel getViewModel() {
        return vm;
    }

    //---------------------                 DAO                --------------------------------------------------------
    public static ProductDAO getProductDao() {
        return new ProductDAOImpl(Factory.getConnection());
    }

    public static UserDAOImpl getUserDao() {
        return new UserDAOImpl(Factory.getConnection());
    }

    public static UserDataDAOImpl getUserDataDao() {
        return new UserDataDAOImpl(Factory.getConnection());
    }

    public static CategoryDAO getCategoryDao() {
        return new CategoryDAOImpl(Factory.getConnection());
    }

    public static CategoryDAO categoryDaoByConnection(Connection connection) {
        return new CategoryDAOImpl(connection);
    }

    public static CategoryDAO getCategoryDAO() {
        return new CategoryDAOImpl(Factory.getConnection());
    }

    public static OrderDAO getOrderDAO() {
        return new OrderDAOImpl(Factory.getConnection());
    }

    public static OrderItemDAO getOrderItemDAO() {
        return new OrderItemDAOImpl(Factory.getConnection());
    }

    //---------------------                 Serveries                ----------------------------------------------------

    private static UserService getUserService() {
        return new UserServiceImpl(Factory.getUserDao());
    }

    private static UserDataService getUserDataService() {
        return new UserDataServiceImpl(Factory.getUserDataDao());
    }

    public static CategoryService getCategoriesService() {
        return new CategoryServiceImpl(Factory.getCategoryDAO());
    }

    public static ProductService getProductService() {
        return new ProductServiceImpl(Factory.getProductDao());
    }

    //---------------------                 get pages                ---------------------------------------------------

    public static Controller getHomeController() {
        return new HomePageController(Factory.getProductService(), Factory.getCategoriesService());
    }

    public static Controller getLoginPageController() {
        return new LoginPageController();
    }

    public static Controller getLogoutPageController() {
        return new LogoutPageController();
    }

    public static Controller getRegistrationPageController() {
        return new RegistrationPageController();
    }

    public static Controller getProfilePageController() {
        return new ProfilePageController();
    }

    public static Controller getForgotPassword() {
        return new ForgotPasswordController();
    }

    public static Controller getEditUserProfileController() {
        return new EditUserProfileController();
    }

    public static Controller getUserProfileController() {
        return new UserProfileController();
    }

    public static Controller getProductController() {
        return new ProductController(Factory.getCategoriesService());
    }

    //----------------------               Post handling            --------------------------------------------

    public static Controller getLoginCheckController() {
        return new LoginCheckController(Factory.getUserService(), Factory.getUserDataService());
    }

    public static Controller getSignUpCheckController() {
        return new SignUpCheckController(Factory.getUserService());
    }

    public static Controller getUserDataController() {
        return new UserDataController(Factory.getUserDataService());
    }

    public static Controller getCreateCategoryController() {
        return new CreateCategoryController(Factory.getCategoriesService());
    }

    public static Controller getCreateProductController() {
        return new CreateProductController(Factory.getProductService(), Factory.getCategoriesService());
    }

    public static Controller getSendForgotPassword() {
        return new SendForgotPasword(Factory.getUserDataService());
    }

    public static Controller getImageUploadController() {
        return new UploadPhotoController();
    }

    public static Controller getSelectGoodsController() {return new SelectGoodsController(Factory.getProductService(),Factory.getCategoriesService());
    }
}