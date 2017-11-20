package by.epam.tr.service.impl;

import by.epam.tr.dao.DAOFactory;
import by.epam.tr.dao.Pagination;
import by.epam.tr.dao.Parser;
import by.epam.tr.dao.exception.ParserException;
import by.epam.tr.dao.impl.PaginationImpl;
import by.epam.tr.entity.Page;
import by.epam.tr.entity.Person;
import by.epam.tr.service.Service;
import by.epam.tr.service.exception.ServiceException;

import java.util.List;

public class ServiceImpl implements Service {

    private Pagination pagination = new PaginationImpl();
    @Override
    public Page<Person> parse(String typeParser, int currentPage) throws ServiceException {
        try {
            Parser parser = DAOFactory.getInstance().getParser(typeParser);
            List<Person> list = parser.parseXML();
            return pagination.getAllPageInformation(list,currentPage);
        } catch (ParserException e) {
            throw new ServiceException(e);
        }
    }
}
