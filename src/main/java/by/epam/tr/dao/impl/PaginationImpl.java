package by.epam.tr.dao.impl;

import by.epam.tr.dao.Pagination;
import by.epam.tr.entity.Page;
import by.epam.tr.entity.Person;

import java.util.List;

public class PaginationImpl implements Pagination {

    private int currentPage;

    private static final int MAX_ENTRIES_PER_PAGE = 5;

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    @Override
    public Page<Person> getAllPageInformation(List<Person> list) {
        Page<Person> page = new Page<>();
        page.setCurrentPage(currentPage);
        int numberOfPages = getPage(list, MAX_ENTRIES_PER_PAGE);
        page.setNumberOfPages(numberOfPages);
        int offset = MAX_ENTRIES_PER_PAGE * (currentPage - 1);
        List<Person> listByOffsetAndLength = getListByOffsetAndLength(offset, list);
        page.setEntity(listByOffsetAndLength);
        return page;
    }


    private List<Person> getListByOffsetAndLength(int offset, List<Person> list) {
        int to = offset + MAX_ENTRIES_PER_PAGE;
        if (offset > list.size()) {
            offset = list.size();
        }
        if (to > list.size()) {
            to = list.size();
        }
        return list.subList(offset, to);
    }


    private int getPage(List<Person> list, int length) {
        int pages = list.size() / length;
        if (list.size() % length != 0) {
            pages += 1;
        }
        return pages;
    }


}
