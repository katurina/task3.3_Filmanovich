package by.epam.tr.service;

import by.epam.tr.entity.Page;
import by.epam.tr.entity.Person;
import by.epam.tr.service.exception.ServiceException;

public interface Service {
    Page<Person> parse(String typeParser, int currentPage) throws ServiceException;
}
