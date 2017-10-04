package com.fluffypets.mvc.controller.pages;

import com.fluffypets.mvc.controller.Controller;
import com.fluffypets.mvc.servlets.Action;
import com.fluffypets.mvc.servlets.ViewModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

public class LogoutPageController implements Controller {
    private static final Logger logger = LogManager.getLogger(LogoutPageController.class.getName());

    @Override
    public ViewModel process(Action action, ViewModel vm) {
        vm.setAttributes(new HashMap<>());
        vm.setView("login");
        logger.info("logout page selected");
        return vm;
    }
}

