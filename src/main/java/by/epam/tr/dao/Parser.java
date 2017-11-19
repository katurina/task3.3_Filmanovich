package by.epam.tr.dao;

import by.epam.tr.dao.exception.ParserException;
import by.epam.tr.entity.Page;
import by.epam.tr.entity.Person;

public interface Parser {
    Page<Person> parse() throws ParserException;
    void setCurrentPage(int currentPage);
}
