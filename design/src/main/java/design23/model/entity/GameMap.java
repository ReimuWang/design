package design23.model.entity;

public class GameMap {

    private Grid[][] grids;

    private int focusR;

    private int focusC;

    private int stageCount;

    /**
     * @param row 地图上小格子的行数
     * @param column 地图上小格子的列数
     * @param stageCount 人物行走状态。
     * @param focusR 人物所在的小格子的行号
     * @param focusC 人物所在的小格子的列号
     * @param initDirection 初始时人物的朝向 
     */
    public GameMap(int row, int column, int stageCount, int focusR, int focusC, int direction) {
        this.stageCount = stageCount;
        this.grids = new Grid[row][column];
        for (int r = 0; r < row; r++)
            for (int c = 0; c < column; c++)
                this.grids[r][c] = new Grid();
        this.focusR = focusR;
        this.focusC = focusC;
        this.grids[this.focusR][this.focusC].setDirection(direction);
        this.grids[this.focusR][this.focusC].setStage(1);
        this.grids[this.focusR][this.focusC].setTimes(1);
    }

    public Grid[][] getGrids() {
        return grids;
    }

    public int getFocusR() {
        return focusR;
    }

    public void setFocusR(int focusR) {
        this.focusR = focusR;
    }

    public int getFocusC() {
        return focusC;
    }

    public void setFocusC(int focusC) {
        this.focusC = focusC;
    }

    public int getStageCount() {
        return stageCount;
    }
}