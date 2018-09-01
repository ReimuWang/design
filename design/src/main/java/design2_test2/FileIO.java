package design2_test2;

import java.io.IOException;
import java.util.Date;

public interface FileIO {

    void readFromFile(String filename) throws IOException;

    void writeToFile(String filename) throws IOException;

    void setTime();

    Date getTime();
}