package by.epam.tr.service;

import by.epam.tr.entity.Person;
import by.epam.tr.service.exception.ServiceException;

import java.util.List;

public interface Service {
    List<Person> parse(String type) throws ServiceException;
}
