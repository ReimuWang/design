package design23.model.parse;

import design23.model.entity.GameMap;

/**
 * <program> ::= program <command list>
 */
public class ProgramNode extends Node {

    private CommandListNode commandListNode;

    private static final String PROGRAM_STR = "program";

    @Override
    public void parse(Context context) throws ParseException {
        context.skip(ProgramNode.PROGRAM_STR);
        this.commandListNode = new CommandListNode();
        this.commandListNode.parse(context);
    }

    @Override
    public String toString() {
        return "[" + ProgramNode.PROGRAM_STR + " " + this.commandListNode + "]";
    }

    @Override
    public void exe(GameMap map) {
        this.commandListNode.exe(map);
    }
}