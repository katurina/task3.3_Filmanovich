package by.epam.tr.controller;

import by.epam.tr.entity.Page;
import by.epam.tr.entity.Person;
import by.epam.tr.service.Service;
import by.epam.tr.service.ServiceFactory;
import by.epam.tr.service.exception.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {

    private static final String PARSER_KIND = "parser";
    private static final String CURRENT_PAGE = "page";
    private static final String LIST = "list";
    private static final String XML_VIEWER = "xmlViewer";


    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        Page<Person> page;
        int currentPage = 1;
        String pageNumberValue = request.getParameter(CURRENT_PAGE);
        String parserParam = request.getParameter(PARSER_KIND);

        if (pageNumberValue != null) {
            try {
                currentPage = Integer.parseInt(pageNumberValue);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        page = getList(parserParam, currentPage);

        request.setAttribute(PARSER_KIND, parserParam);
        request.setAttribute(LIST, page);

        RequestDispatcher dispatcher = request.getRequestDispatcher(XML_VIEWER);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private Page<Person> getList(String parserParam, int currentPage) {
        Service service = ServiceFactory.getInstance().getService();
        try {
            return service.parse(parserParam, currentPage);
        } catch (ServiceException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

