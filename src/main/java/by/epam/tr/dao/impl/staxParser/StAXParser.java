package by.epam.tr.dao.impl.staxParser;


import by.epam.tr.dao.Parser;
import by.epam.tr.dao.exception.ParserException;
import by.epam.tr.entity.Page;
import by.epam.tr.entity.Person;

public class StAXParser implements Parser {
    @Override
    public Page<Person> parse() throws ParserException {
        return null;
    }

    @Override
    public void setCurrentPage(int currentPage) {

    }
}
