package by.epam.tr.dao.impl.domParser;


import by.epam.tr.dao.Parser;
import by.epam.tr.dao.exception.ParserException;
import by.epam.tr.entity.Page;
import by.epam.tr.entity.Person;

public class DOMParser implements Parser {
    private int currentPage;
    @Override
    public Page<Person> parse() throws ParserException {
        return null;
    }

    @Override
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
