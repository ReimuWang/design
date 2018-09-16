package design22.view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import design22.command.MacroCommand;

public class MyCanvas extends Canvas {

    private static final long serialVersionUID = 1L;

    private static final Color DEF_COLOR = Color.BLACK;

    private static final int DEF_R = 10;

    Color color = MyCanvas.DEF_COLOR;

    int r = MyCanvas.DEF_R;

    MacroCommand history = new MacroCommand(this);

    public MyCanvas(int width, int height) {
        this.setSize(width, height);
        this.setBackground(Color.WHITE);
    }

    public void paint(Graphics g) {
        this.init();
        this.history.execute();
    }

    public void draw(Point point) {
        Graphics g = this.getGraphics();
        g.setColor(this.color);
        g.fillOval(point.x - this.r, point.y - this.r, 2 * this.r, 2 * this.r);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setR(int r) {
        this.r = r;
    }

    public void init() {
        this.color = MyCanvas.DEF_COLOR;
        this.r = MyCanvas.DEF_R;
    }
}