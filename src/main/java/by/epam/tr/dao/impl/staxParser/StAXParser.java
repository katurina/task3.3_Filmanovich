package by.epam.tr.dao.impl.staxParser;

import by.epam.tr.dao.Pagination;
import by.epam.tr.dao.Parser;
import by.epam.tr.dao.exception.ParserException;
import by.epam.tr.dao.impl.PaginationImpl;
import by.epam.tr.entity.Page;
import by.epam.tr.entity.Person;
import by.epam.tr.entity.XMLTagName;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class StAXParser implements Parser {
    private static final String PEOPLE_XML = "people.xml";
    private int currentPage;

    @Override
    public Page<Person> parse() throws ParserException {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        InputStream inputStream;
        try {
            inputStream = getClass().getClassLoader().getResourceAsStream(PEOPLE_XML);

            XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(inputStream);
            List<Person> listPerson = process(xmlStreamReader);

            Pagination pagination = new PaginationImpl();
            pagination.setCurrentPage(currentPage);

            return pagination.getAllPageInformation(listPerson);

        } catch (XMLStreamException e) {
            throw new ParserException(e);
        }
    }

    @Override
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    private List<Person> process(XMLStreamReader reader) throws XMLStreamException {
        List<Person> listPerson = new ArrayList<>();
        Person person = null;
        XMLTagName elementName = null;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    elementName = XMLTagName.getXMLTagName(reader.getLocalName());
                    switch (elementName) {
                        case PERSON:
                            person = new Person();
                            Integer id = Integer.parseInt(reader.getAttributeValue(null, "id"));
                            person.setId(id);
                            break;
                    }
                    break;
                case XMLStreamConstants.CHARACTERS:
                    String text = reader.getText().trim();
                    if (text.isEmpty()) {
                        break;
                    }
                    switch (elementName) {
                        case NAME:
                            person.setName(text);
                            break;
                        case SURNAME:
                            person.setSurname(text);
                            break;
                        case EMAIL:
                            person.setEmail(text);
                            break;
                        case TELEPHONE:
                            person.setTelephone(text);
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    elementName = XMLTagName.getXMLTagName(reader.getLocalName());
                    switch (elementName) {
                        case PERSON:
                            listPerson.add(person);
                    }
            }
        }
        return listPerson;
    }
}
