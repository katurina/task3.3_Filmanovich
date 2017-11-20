package by.epam.tr.dao.impl.domParser;


import by.epam.tr.dao.Parser;
import by.epam.tr.dao.exception.ParserException;
import by.epam.tr.entity.Person;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MyDOMParser implements Parser {
    private static final String PEOPLE_XML = "people.xml";
    private static final String PERSON = "person";

    @Override
    public List<Person> parseXML() throws ParserException {
        try {
            return getPeopleList();
        } catch (SAXException | IOException e) {
            throw new ParserException(e);
        }
    }

    private List<Person> getPeopleList() throws SAXException, IOException {
        DOMParser domParser = new DOMParser();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(PEOPLE_XML);
        InputSource inputSource = new InputSource(inputStream);
        domParser.parse(inputSource);
        Document document = domParser.getDocument();
        Element root = document.getDocumentElement();
        List<Person> people = new ArrayList<>();

        NodeList personNodes = root.getElementsByTagName(PERSON);
        Person person;
        for (int i = 0; i < personNodes.getLength(); i++) {
            person = getPerson(personNodes, i);
            people.add(person);
        }
        return people;
    }

    private Person getPerson(NodeList personNodes, int i) {
        Person person;
        person = new Person();
        Element personElement = (Element) personNodes.item(i);
        person.setId(Integer.parseInt(personElement.getAttribute("id")));
        person.setName(getSingleChild(personElement, "name").getTextContent().trim());
        person.setSurname(getSingleChild(personElement, "surname").getTextContent().trim());
        person.setTelephone(getSingleChild(personElement, "telephone").getTextContent().trim());
        person.setEmail(getSingleChild(personElement, "email").getTextContent().trim());
        return person;
    }

    private static Element getSingleChild(Element element, String childName) {
        NodeList nodeList = element.getElementsByTagName(childName);
        return (Element) nodeList.item(0);
    }
}
