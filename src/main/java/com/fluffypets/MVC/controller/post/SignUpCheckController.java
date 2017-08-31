package com.fluffypets.MVC.controller.post;

import com.fluffypets.MVC.controller.Controller;
import com.fluffypets.MVC.model.User;
import com.fluffypets.MVC.servlets.Request;
import com.fluffypets.MVC.servlets.ViewModel;
import com.fluffypets.factory.Factory;
import com.fluffypets.servicies.UserService;

public class SignUpCheckController implements Controller {
    private UserService userService;

    public SignUpCheckController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ViewModel process(Request request) {
        ViewModel vm = Factory.getViewModel();
        String userName = request.getAttribute("form-userName");
        String email = request.getAttribute("form-email");
        String password = request.getAttribute("form-password");
        String token=userName+System.nanoTime();
        String role="user";
        User user = new User(1,userName,password,token,email,role);
        user=userService.create(user);
        vm.setAttribute("user", user);
        vm.addCookie("token", user.getToken());
        vm.setView("profile");
        return vm;
    }
}