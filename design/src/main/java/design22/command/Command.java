package design22.command;

import java.util.List;

public interface Command {

    void execute();

    List<String> strList();
}