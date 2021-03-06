package com.fluffypets.mvc.controller.post;

import com.fluffypets.mvc.controller.Controller;
import com.fluffypets.mvc.servlets.Action;
import com.fluffypets.mvc.servlets.ViewModel;
import com.fluffypets.services.OrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;

public class AdminEditOrdersController implements Controller {
    private static final Logger logger = LogManager.getLogger(AddProductToCartController.class.getName());

    private OrderService orderService;

    public AdminEditOrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public ViewModel process(Action request, ViewModel vm) {
        String command = request.getAttribute("command");
        String status = request.getAttribute("status");
        LocalDate delivery = LocalDate.parse(request.getAttribute("delivery"));
        Integer orderId = new Integer(request.getAttribute("orderId"));

        if (command.equals("update")) {
            orderService.changeOrderStatus(orderId, delivery, status);
            vm.setAttribute("orders", orderService.getAllOrders());
        }
        if (command.equals("delete")) {
            orderService.delete(orderId);
            vm.setAttribute("orders", orderService.getAllOrders());
        }
        vm.setView("adminOrders");
        logger.info("changed status for orderId");
        return vm;
    }
}