package design23.model.parse;

import java.util.ArrayList;
import java.util.List;

import design23.model.entity.GameMap;

/**
 * <command list> ::= <command>* end
 */
public class CommandListNode extends Node {

    private List<CommandNode> commandList = new ArrayList<CommandNode>();

    @Override
    public void parse(Context context) throws ParseException {
        while (true) {
            String current = context.peek();
            String endstr = "end";
            if (null == current) throw new ParseException("Missing '" + endstr + "'");
            if (endstr.equals(current)) {
                context.skip(endstr);
                break;
            }
            CommandNode commandNode = new CommandNode();
            this.commandList.add(commandNode);
            commandNode.parse(context);
        }
    }

    @Override
    public String toString() {
        return this.commandList.toString();
    }

    @Override
    public void exe(GameMap map) {
        for (CommandNode commandNode : this.commandList)
            commandNode.exe(map);
    }
}