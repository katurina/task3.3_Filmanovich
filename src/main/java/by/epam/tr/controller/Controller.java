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
    private static final String PAGE = "page";
    private static final String NUMBER_OF_PAGES = "numberOfPages";
    private static final String CURRENT_PAGE = "currentPage";
    private static final String LIST = "list";
    private static final String XML_VIEWER = "xmlViewer";

    private int offset;
    private int length;
    private List<Person> list;
    private String parserParam;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        int maxEntriesPerPage = 5;
        int currentPage = 1;

        String pageNumberValue = request.getParameter(PAGE);
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

        request.setAttribute(NUMBER_OF_PAGES, getPage());
        request.setAttribute(CURRENT_PAGE, currentPage);
        request.setAttribute(LIST, getListByOffsetAndLength());

        RequestDispatcher dispatcher = request.getRequestDispatcher(XML_VIEWER);
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

