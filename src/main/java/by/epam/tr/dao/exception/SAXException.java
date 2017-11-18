package by.epam.tr.dao.exception;

public class SAXException extends ParserException {
    public SAXException() {
        super();
    }

    public SAXException(String message) {
        super(message);
    }

    public SAXException(Throwable e) {
        super(e);
    }

    public SAXException(String message, Throwable e) {
        super(message, e);
    }
}
