package by.epam.tr.service.impl;

import by.epam.tr.dao.DAOFactory;
import by.epam.tr.dao.Parser;
import by.epam.tr.dao.exception.ParserException;
import by.epam.tr.entity.Person;
import by.epam.tr.service.Service;
import by.epam.tr.service.exception.ServiceException;

import java.util.List;

public class ServiceImpl implements Service {

    @Override
    public List<Person> parse(String type) throws ServiceException {
        try {
            Parser parser = DAOFactory.getInstance().getParser(type);
            return parser.parse();
        } catch (ParserException e) {
            throw new ServiceException(e);
        }
    }
}