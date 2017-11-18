package by.epam.tr.controller;


import by.epam.tr.entity.Person;
import by.epam.tr.service.Service;
import by.epam.tr.service.ServiceFactory;
import by.epam.tr.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Controller extends HttpServlet {

    private static final String KEY = "parser";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Service service = ServiceFactory.getInstance().getService();
            List<Person> list = service.parse(request.getParameter(KEY));

            request.setAttribute("list", list);
            request.getRequestDispatcher("xmlViewer").forward(request, response);

        } catch (ServiceException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
