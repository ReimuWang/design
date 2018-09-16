package design23.model.parse;

import java.util.StringTokenizer;

public class Context {

    private StringTokenizer st;

    private String current;

    public Context(String text) {
        this.st = new StringTokenizer(text);
        this.next();
    }

    String peek() {
        return this.current;
    }

    String next() {
        this.current = this.st.hasMoreTokens() ?
                       this.st.nextToken() :
                       null;
        return this.current;
    }

    void skip(String token) throws ParseException {
        if (!token.equals(this.current))
            throw new ParseException("need " + token + ", but " + this.current + " is found");
        this.next();
    }
}