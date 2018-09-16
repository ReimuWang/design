package design23.model.parse;

import design23.model.entity.GameMap;

public abstract class Node {

    public abstract void parse(Context context) throws ParseException;

    public abstract void exe(GameMap map);
}