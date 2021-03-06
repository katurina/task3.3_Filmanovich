package by.epam.tr.dao;

import by.epam.tr.dao.impl.domParser.MyDOMParser;
import by.epam.tr.dao.impl.saxParser.SAXParser;
import by.epam.tr.dao.impl.staxParser.StAXParser;

public class DAOFactory {
    private static final String SAX = "SAX";
    private static final String STAX = "STAX";
    private static final String DOM = "DOM";


    private static DAOFactory instance = new DAOFactory();

    private Parser saxParser = new SAXParser();
    private Parser staxParser = new StAXParser();
    private Parser domParser = new MyDOMParser();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public Parser getParser(String type) {
        type = type.toUpperCase();
        switch (type) {
            case SAX:
                return saxParser;
            case STAX:
                return staxParser;
            case DOM:
                return domParser;
        }
        return null;
    }
}
