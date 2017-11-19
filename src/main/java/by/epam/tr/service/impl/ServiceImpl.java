package by.epam.tr.service.impl;

import by.epam.tr.dao.DAOFactory;
import by.epam.tr.dao.Parser;
import by.epam.tr.dao.exception.ParserException;
import by.epam.tr.entity.Page;
import by.epam.tr.entity.Person;
import by.epam.tr.service.Service;
import by.epam.tr.service.exception.ServiceException;

public class ServiceImpl implements Service {

    @Override
    public Page<Person> parse(String typeParser, int currentPage) throws ServiceException {
        try {
            Parser parser = DAOFactory.getInstance().getParser(typeParser);
            parser.setCurrentPage(currentPage);
            return parser.parse();
        } catch (ParserException e) {
            throw new ServiceException(e);
        }
    }
}
