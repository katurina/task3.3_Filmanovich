package by.epam.tr.dao;

import by.epam.tr.entity.Page;
import by.epam.tr.entity.Person;

import java.util.List;

public interface Pagination {
    Page<Person> getAllPageInformation(List<Person> list,int currentPage);
}
