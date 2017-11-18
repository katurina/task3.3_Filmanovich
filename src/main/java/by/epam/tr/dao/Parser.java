package by.epam.tr.dao;

import by.epam.tr.dao.exception.ParserException;
import by.epam.tr.entity.Person;

import java.util.List;

public interface Parser {
    List<Person> parse() throws ParserException;
}
