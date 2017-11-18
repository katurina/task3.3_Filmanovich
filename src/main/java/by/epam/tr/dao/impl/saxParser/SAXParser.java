package by.epam.tr.dao.impl.saxParser;

import by.epam.tr.dao.Parser;
import by.epam.tr.dao.exception.ParserException;
import by.epam.tr.entity.Person;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class SAXParser implements Parser {

    private static final String PEOPLE_XML = "people.xml";

    @Override
    public List<Person> parse() throws ParserException {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();

            PeopleSAXHandler handler = new PeopleSAXHandler();
            reader.setContentHandler(handler);

            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(PEOPLE_XML);

            InputSource inputSource = new InputSource(inputStream);
            reader.parse(inputSource);

            return handler.getPersonList();


        } catch (SAXException | IOException e) {
            throw new ParserException(e);
        }

    }
}
