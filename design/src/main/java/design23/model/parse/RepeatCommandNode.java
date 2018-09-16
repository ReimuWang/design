package design23.model.parse;

import design23.model.entity.GameMap;

/**
 * <repeat command> ::= repeat <number> <command list>
 */
public class RepeatCommandNode extends CommandNode {

    private int number;

    private CommandListNode commandListNode;

    @Override
    public void parse(Context context) throws ParseException {
        context.skip(CommandNode.REPEAT_STR);
        try {
            this.number = Integer.parseInt(context.peek());
        } catch (NumberFormatException e) {
            throw new ParseException("fail to parse " + CommandNode.REPEAT_STR + " times." + e);
        }
        context.next();
        this.commandListNode = new CommandListNode();
        this.commandListNode.parse(context);
    }

    @Override
    public String toString() {
        return "[" + CommandNode.REPEAT_STR + " " + this.number + " " + this.commandListNode + "]";
    }

    @Override
    public void exe(GameMap map) {
        for (int i = 0; i < this.number; i++)
            this.commandListNode.exe(map);
    }
}