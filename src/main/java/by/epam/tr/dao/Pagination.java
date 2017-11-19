package by.epam.tr.dao;

import by.epam.tr.entity.Page;
import by.epam.tr.entity.Person;

import java.util.List;

public interface Pagination {
    void setCurrentPage(int currentPage);
    Page<Person> getAllPageInformation(List<Person> list);
}
