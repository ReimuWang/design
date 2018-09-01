package design17_2;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class View extends Frame {

    private static final long serialVersionUID = 1L;

    private Model model;

    private long sleepTime;

    private int lastNumber;

    private int nowNumber;

    public View (Model model) {
        this.model = model;
        this.sleepTime = this.model.sleepTime / 10;
    }

    public void launchFrame() {
        super.setLocation(700, 300);
        super.setSize(300, 150);
        new Thread(this.new RepaintRunnable()).start();
        super.addWindowListener(
            new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        super.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        g.setFont(new Font(null, Font.BOLD, 30));
        if (this.nowNumber != this.model.number) {
            this.lastNumber = this.nowNumber;
            this.nowNumber = this.model.number;
        }
        g.drawString(this.lastNumber + " --> " + this.nowNumber, 100, 100);
    }

    private class RepaintRunnable implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    View.this.repaint();
                    Thread.sleep(View.this.sleepTime);
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
}