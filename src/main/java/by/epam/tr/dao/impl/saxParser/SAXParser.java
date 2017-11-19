package by.epam.tr.dao.impl.saxParser;

import by.epam.tr.dao.Pagination;
import by.epam.tr.dao.Parser;
import by.epam.tr.dao.exception.ParserException;
import by.epam.tr.dao.impl.PaginationImpl;
import by.epam.tr.entity.Page;
import by.epam.tr.entity.Person;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class SAXParser implements Parser {

    private static final String PEOPLE_XML = "people.xml";
    private int currentPage;

    @Override
    public Page<Person> parse() throws ParserException {
        try {
            List<Person> personList = new ArrayList<>();
            if (personList.isEmpty()) {
                XMLReader reader = XMLReaderFactory.createXMLReader();

                PeopleSAXHandler handler = new PeopleSAXHandler();
                reader.setContentHandler(handler);

                InputStream inputStream = getClass().getClassLoader().getResourceAsStream(PEOPLE_XML);

                InputSource inputSource = new InputSource(inputStream);
                reader.parse(inputSource);

                personList = handler.getPersonList();
            }
            Pagination pagination = new PaginationImpl();
            pagination.setCurrentPage(currentPage);
            return pagination.getAllPageInformation(personList);

        } catch (SAXException | IOException e) {
            throw new ParserException(e);
        }
    }

    @Override
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
