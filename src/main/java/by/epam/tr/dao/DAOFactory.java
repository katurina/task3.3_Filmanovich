package by.epam.tr.dao;

import by.epam.tr.dao.impl.domParser.DOMParser;
import by.epam.tr.dao.impl.saxParser.SAXParser;
import by.epam.tr.dao.impl.staxParser.StAXParser;

public class DAOFactory {
    private static DAOFactory instance = new DAOFactory();

    private Parser saxParser = new SAXParser();
    private Parser staxParser = new StAXParser();
    private Parser domParser = new DOMParser();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public Parser getParser(String type) {
        type = type.toUpperCase();
        switch (type) {
            case "SAX":
                return saxParser;
            case "STAX":
                return staxParser;
            case "DOM":
                return domParser;
        }
        return null;
    }
}
