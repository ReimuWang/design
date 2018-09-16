package design23.model.parse;

import design23.model.entity.GameMap;
import design23.model.entity.Grid;

/**
 * <primitive command> ::= go | left | right
 */
public class PrimitiveCommandNode extends CommandNode {

    private String name;

    public static final String GO = "go";

    public static final String LEFT = "left";

    public static final String RIGHT = "right";

    @Override
    public void parse(Context context) throws ParseException {
        this.name = context.peek();
        context.skip(this.name);
        if (!PrimitiveCommandNode.GO.equals(this.name) &&
            !PrimitiveCommandNode.LEFT.equals(this.name) &&
            !PrimitiveCommandNode.RIGHT.equals(this.name))
            throw new ParseException("command " + this.name + " is undefined");
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public void exe(GameMap map) {
        int maxR = map.getGrids().length;
        int maxC = map.getGrids()[0].length;
        int focusR = map.getFocusR();
        int focusC = map.getFocusC();
        Grid focusGrid = map.getGrids()[focusR][focusC];
        int direction = focusGrid.getDirection();
        if (PrimitiveCommandNode.GO.equals(this.name)) {
            int newFocusR = focusR;
            int newFocusC = focusC;
            switch (direction) {
            case 0:
                if (focusR + 1 == maxR) break;
                newFocusR = focusR + 1;
                break;
            case 1:
                if (focusC == 0) break;
                newFocusC = focusC - 1;
                break;
            case 2:
                if (focusC + 1 == maxC) break;
                newFocusC = focusC + 1;
                break;
            case 3:
                if (focusR == 0) break;
                newFocusR = focusR - 1;
            }
            // 模拟走路动作
            for (int i = 0; i < map.getStageCount(); i++) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                focusGrid.setStage((focusGrid.getStage() + 1) % map.getStageCount());
                if (i == map.getStageCount() / 2) {
                    // 设置新的焦点格
                    map.getGrids()[newFocusR][newFocusC].setDirection(direction);
                    map.getGrids()[newFocusR][newFocusC].setStage(focusGrid.getStage());
                    map.getGrids()[newFocusR][newFocusC].setTimes(map.getGrids()[newFocusR][newFocusC].getTimes() + 1);
                    map.setFocusR(newFocusR);
                    map.setFocusC(newFocusC);
                    // 设置原来的焦点格
                    focusGrid.setDirection(-1);
                    focusGrid.setStage(-1);
                }
            }
        } else if (PrimitiveCommandNode.LEFT.equals(this.name)) {
            switch (direction) {
            case 0:
                focusGrid.setDirection(2);
                break;
            case 1:
                focusGrid.setDirection(0);
                break;
            case 2:
                focusGrid.setDirection(3);
                break;
            case 3:
                focusGrid.setDirection(1);
            }
        } else {
            switch (direction) {
            case 0:
                focusGrid.setDirection(1);
                break;
            case 1:
                focusGrid.setDirection(3);
                break;
            case 2:
                focusGrid.setDirection(0);
                break;
            case 3:
                focusGrid.setDirection(2);
            }
        }
    }
}