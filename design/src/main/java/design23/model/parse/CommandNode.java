package design23.model.parse;

import design23.model.entity.GameMap;

/**
 * <command> ::= <repeat command> | <primitive command>
 */
public class CommandNode extends Node {

    private CommandNode commandNode;

    protected static final String REPEAT_STR = "repeat";

    @Override
    public void parse(Context context) throws ParseException {
        this.commandNode = CommandNode.REPEAT_STR.equals(context.peek()) ?
                           new RepeatCommandNode() :
                           new PrimitiveCommandNode();
        this.commandNode.parse(context);

    }

    @Override
    public String toString() {
        return this.commandNode.toString();
    }

    @Override
    public void exe(GameMap map) {
        this.commandNode.exe(map);
    }
}