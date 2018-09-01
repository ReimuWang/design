package design2_test2;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        FileIO fileIO = new FileProperties();
        fileIO.readFromFile("D:" + File.separator + "test.txt");
        System.out.println(fileIO.getTime());
    }
}