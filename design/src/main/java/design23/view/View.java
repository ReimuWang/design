package design23.view;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import design23.model.Model;
import design23.model.entity.Grid;

public class View extends Frame {

    private static final long serialVersionUID = 1L;

    private int gridSize = 32;

    private int widebar = 31;

    private int narrowbar = 6;

    private Model model = new Model();

    private BufferedImage img = this.loadImg("character.png");

    public void launchFrame() {
        int gridRow = 7;
        int gridColumn = 7;
        this.model.initMap(gridRow, gridColumn, 3, 3, 0, 3);
        this.model.initInterpreter("src/main/java/design23/code.txt");
        super.setLocation(800, 300);
        super.setSize(this.narrowbar + this.gridSize * gridColumn + this.narrowbar, this.widebar + this.gridSize * gridRow + this.narrowbar);
        new Thread(this.new RepaintRunnable()).start();
        super.addWindowListener(
            new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.model.exe();
        super.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        Grid[][] grids = this.model.getMap().getGrids();
        for (int r = 0; r < grids.length; r++) {
            for (int c = 0; c < grids[0].length; c++) {
                Grid grid = grids[r][c];
                int dx1 = this.narrowbar + c * this.gridSize;
                int dy1 = this.widebar + r * this.gridSize;
                if (grid.getTimes() > 0) {
                    Color tempColor = g.getColor();
                    g.setColor(Color.GRAY);
                    g.fillRect(dx1, dy1, this.gridSize, this.gridSize);
                    g.setColor(tempColor);
                }
                if (grid.getDirection() >= 0) {
                    int direction = grid.getDirection();
                    int stage = grid.getStage();
                    g.drawImage(this.img,
                                dx1,
                                dy1,
                                this.narrowbar + c * this.gridSize + this.gridSize,
                                this.widebar + r * this.gridSize + this.gridSize,
                                stage * this.gridSize,
                                direction * this.gridSize,
                                stage * this.gridSize + this.gridSize,
                                direction * this.gridSize + this.gridSize,
                                null);
                }
            }
        }
    }

    private class RepaintRunnable implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    View.this.repaint();
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void update(Graphics g) {
        Image bImage = super.createImage(this.getWidth(), this.getHeight());
        Graphics bg = bImage.getGraphics();
        this.paint(bg);
        bg.dispose();
        g.drawImage(bImage, 0, 0, this);
    }

    private BufferedImage loadImg(String name) {
        BufferedImage bImage = null;
        try {
            bImage = ImageIO.read(View.class.getClassLoader().getResource("design23/" + name));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bImage;
    }
}