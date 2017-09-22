package com.fluffypets.MVC.controller.pages;

import com.fluffypets.MVC.controller.Controller;
import com.fluffypets.MVC.model.Cart;
import com.fluffypets.MVC.model.Category;
import com.fluffypets.MVC.model.Product;
import com.fluffypets.MVC.model.User;
import com.fluffypets.MVC.model.enumes.Prices;
import com.fluffypets.MVC.servlets.Request;
import com.fluffypets.MVC.servlets.ViewModel;
import com.fluffypets.servicies.CategoryService;
import com.fluffypets.servicies.ProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.ResourceBundle;

public class HomePageController implements Controller, AutoCloseable {
    private static final Logger logger = LogManager.getLogger(HomePageController.class.getName());

    private ProductService productService;
    private CategoryService categoryService;

    public HomePageController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @Override
    public ViewModel process(Request request, ViewModel vm) {

        List<Product> products = productService.getAll();
        List<Category> categories = categoryService.getAll();

        vm.setAttribute("products", products);
        vm.setAttribute("categories", categories);
        vm.setAttribute("prices", Prices.values());

//        -------------         localization for page home     ----------------------
        ResourceBundle resourceBundle = ResourceBundle.getBundle("lang", vm.getCurrentLocale());
        vm.setAttribute("Add_to_cart", ViewModel.stringUTF8(resourceBundle.getString("Add_to_cart")));
        vm.setAttribute("Admin_page", ViewModel.stringUTF8(resourceBundle.getString("Admin_page")));
        vm.setAttribute("Confirm_your_order", ViewModel.stringUTF8(resourceBundle.getString("Confirm_your_order")));
        vm.setAttribute("Create_product", ViewModel.stringUTF8(resourceBundle.getString("Create_product")));
        vm.setAttribute("Logout", ViewModel.stringUTF8(resourceBundle.getString("Logout")));
        vm.setAttribute("My_cart", ViewModel.stringUTF8(resourceBundle.getString("My_cart")));
        vm.setAttribute("My_profile", ViewModel.stringUTF8(resourceBundle.getString("My_profile")));
        vm.setAttribute("Products", ViewModel.stringUTF8(resourceBundle.getString("Products")));
        vm.setAttribute("Select_categories", ViewModel.stringUTF8(resourceBundle.getString("Select_categories")));
        vm.setAttribute("Select_price_range", ViewModel.stringUTF8(resourceBundle.getString("Select_price_range")));
        vm.setAttribute("Signin", ViewModel.stringUTF8(resourceBundle.getString("Signin")));
        vm.setAttribute("Signup", ViewModel.stringUTF8(resourceBundle.getString("Signup")));
        vm.setAttribute("Welcome", ViewModel.stringUTF8(resourceBundle.getString("Welcome")));
        vm.setAttribute("message_L", ViewModel.stringUTF8(resourceBundle.getString("message_L")));
        vm.setAttribute("All", ViewModel.stringUTF8(resourceBundle.getString("All")));
        vm.setAttribute("Language", ViewModel.stringUTF8(resourceBundle.getString("Language")));
        vm.setAttribute("Select", ViewModel.stringUTF8(resourceBundle.getString("Select")));
//        =============         localization        ======================


        User user = (User) vm.getAttribute("user");
        if (user == null) {
            user = new User(0, "Unknown", "", "", "", "user");
        }

        Cart cart = (Cart) vm.getAttribute("cart");
        if (cart == null) {
            cart = new Cart(user);
        } else {
            cart.setUser(user);
        }
        vm.setAttribute("cart", cart);
        vm.setView("home");
        logger.info("home page selected");
        return vm;
    }

    @Override
    public void close() throws Exception {
        productService.close();
        categoryService.close();
    }
}
