package by.epam.tr.dao.exception;

public class ParserException extends Exception {
    public ParserException() {
        super();
    }

    public ParserException(String message) {
        super(message);
    }

    public ParserException(Throwable e) {
        super(e);
    }

    public ParserException(String message, Throwable e) {
        super(message, e);
    }
}
