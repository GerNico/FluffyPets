package com.fluffypets.mvc.controller.pages;

import com.fluffypets.mvc.controller.Controller;
import com.fluffypets.entities.User;
import com.fluffypets.mvc.servlets.Action;
import com.fluffypets.mvc.servlets.ViewModel;
import com.fluffypets.services.UserService;

import java.util.List;

public class AdminPageController implements Controller {

    private UserService userService;

    public AdminPageController(UserService userService){this.userService=userService;}

    @Override
    public ViewModel process(Action action, ViewModel vm) {
        List<User> users= userService.getAllUsers();
            vm.setAttribute("users", users);
            vm.setView("admin");
        return vm;
    }
}
