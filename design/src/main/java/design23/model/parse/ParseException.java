package design23.model.parse;

public class ParseException extends Exception {

    private static final long serialVersionUID = 1L;

    ParseException(String msg) {
        super(msg);
    }
}