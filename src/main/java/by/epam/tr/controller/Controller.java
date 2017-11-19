package by.epam.tr.controller;


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
import java.util.ArrayList;
import java.util.List;

public class Controller extends HttpServlet {

    private static final String PARSER_KIND = "parser";
    private int offset;
    private int length;
    private List<Person> list;
    private String parserParam;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        int maxEntriesPerPage = 5;
        int currentPage = 1;

        String pageNumberValue = request.getParameter("page");
        parserParam = request.getParameter(PARSER_KIND);

        if (pageNumberValue != null) {
            try {
                currentPage = Integer.parseInt(pageNumberValue);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        this.offset = maxEntriesPerPage * (currentPage - 1);
        this.length = maxEntriesPerPage;
        getList();

        request.setAttribute("numberOfPages", getPage());
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("list", getListByOffsetAndLength());

        RequestDispatcher dispatcher = request.getRequestDispatcher("xmlViewer");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private void getList() {
        if (list == null) {
            Service service = ServiceFactory.getInstance().getService();
            try {
                list = service.parse(parserParam);
            } catch (ServiceException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

    private List<Person> getListByOffsetAndLength() {
        List<Person> list = new ArrayList<>();
        int to = this.offset + this.length;
        if (this.offset > this.list.size()) {
            this.offset = this.list.size();
        }
        if (to > this.list.size()) {
            to = this.list.size();
        }
        for (int i = this.offset; i < to; i++) {
            list.add(this.list.get(i));
        }
        return list;
    }


    private int getPage() {
        int pages = list.size() / length;
        if (list.size() % length != 0) {
            pages += 1;
        }
        return pages;
    }
}

