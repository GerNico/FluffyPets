package com.fluffypets.MVC.filtres;

import com.fluffypets.DAO.user.UserDAOImpl;
import com.fluffypets.MVC.model.User;
import com.fluffypets.factory.Factory;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdminFilter implements Filter {

    private UserDAOImpl userDAO;
    private List<String> protectedUrls = new ArrayList<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        userDAO = Factory.getUserDao();
        protectedUrls.add("/root/admin");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        Cookie[] cookies = httpServletRequest.getCookies();
        String uri = httpServletRequest.getRequestURI();

        if (protectedUrls.contains(uri)) {
            String token = null;
            for (Cookie cookie : cookies) {
                String name = cookie.getName().toLowerCase();
                String TOKEN = "token";
                if (TOKEN.equals(name)) {
                    token = cookie.getValue();
                    User user = userDAO.findByToken(token);
                    if (user.getRoleString().equals("admin")) {
                        request.setAttribute("user", user);
                    } else {
                        request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
                    }
                }
            }
            if (token == null) {
                request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}