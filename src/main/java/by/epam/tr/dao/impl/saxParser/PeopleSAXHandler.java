package by.epam.tr.dao.impl.saxParser;

import by.epam.tr.entity.Person;
import by.epam.tr.entity.XMLTagName;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class PeopleSAXHandler extends DefaultHandler {
    private List<Person> personList = new ArrayList<>();
    private Person person;
    private StringBuilder text;

    public List<Person> getPersonList() {
        return personList;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        text = new StringBuilder();
        if (qName.equals("person")) {
            person = new Person();
            person.setId(Integer.parseInt(attributes.getValue("id")));
        }
    }

    public void characters(char[] buffer, int start, int length) {
        text.append(buffer, start, length);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        XMLTagName tagName = XMLTagName.valueOf(localName.toUpperCase());
        switch (tagName) {
            case PERSON:
                personList.add(person);
                person = null;
                break;
            case NAME:
                person.setName(text.toString());
                break;
            case SURNAME:
                person.setSurname(text.toString());
                break;
            case TELEPHONE:
                person.setTelephone(text.toString());
                break;
            case EMAIL:
                person.setEmail(text.toString());
                break;
            case PEOPLE:
                break;
        }
    }

}
