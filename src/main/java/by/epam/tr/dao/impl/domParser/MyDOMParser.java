package by.epam.tr.dao.impl.domParser;


import by.epam.tr.dao.Pagination;
import by.epam.tr.dao.Parser;
import by.epam.tr.dao.exception.ParserException;
import by.epam.tr.dao.impl.PaginationImpl;
import by.epam.tr.entity.Page;
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
    private int currentPage;

    @Override
    public Page<Person> parse() throws ParserException {
        try {
            List<Person> peopleList = getPeopleList();
            Pagination pagination = new PaginationImpl();
            pagination.setCurrentPage(currentPage);
            return pagination.getAllPageInformation(peopleList);

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

        NodeList personNodes = root.getElementsByTagName("person");
        Person person;
        for (int i = 0; i < personNodes.getLength(); i++) {
            person = new Person();
            Element personElement = (Element) personNodes.item(i);
            person.setId(Integer.parseInt(personElement.getAttribute("id")));
            person.setName(getSingleChild(personElement, "name").getTextContent().trim());
            person.setSurname(getSingleChild(personElement, "surname").getTextContent().trim());
            person.setTelephone(getSingleChild(personElement, "telephone").getTextContent().trim());
            person.setEmail(getSingleChild(personElement, "email").getTextContent().trim());
            people.add(person);
        }
        return people;
    }

    @Override
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    private static Element getSingleChild(Element element, String childName) {
        NodeList nodeList = element.getElementsByTagName(childName);
        return (Element) nodeList.item(0);
    }
}
