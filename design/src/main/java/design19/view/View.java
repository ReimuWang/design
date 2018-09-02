package design19.view;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import design19.model.Hero;
import design19.model.Nidalee;

public class View extends Frame {

    private static final long serialVersionUID = 1L;

    private Hero nidalee = new Nidalee();

    public void launchFrame() {
        super.setLocation(500, 200);
        super.setSize(330, 713);
        new Thread(this.new RepaintRunnable()).start();
        super.addWindowListener(
            new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        super.addKeyListener(
            new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    switch(e.getKeyCode()) {
                    case KeyEvent.VK_Q:
                        View.this.nidalee.useQ();
                        break;
                    case KeyEvent.VK_W:
                        View.this.nidalee.useW();
                        break;
                    case KeyEvent.VK_E:
                        View.this.nidalee.useE();
                        break;
                    case KeyEvent.VK_R:
                        View.this.nidalee.useR();
                        break;
                    case KeyEvent.VK_X:
                        View.this.nidalee.damage(1000);
                        break;
                    }
                }
            }
        );
        super.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        // 基本参数
        int leftBar = 11;
        int aboveBar = 45;
        int imgWidth = 308;
        int imgHeight = 560;
        int skillWidth = 308 / 4;
        // 血条蓝条
        int slotHeight = 10;
        g.setColor(this.getHealthColor());
        g.fillRect(leftBar, aboveBar, (int)(imgWidth * this.nidalee.getHealthRate()), slotHeight);
        if (this.nidalee.ifHaveMana()) {
            g.setColor(Color.BLUE);
            g.fillRect(leftBar, aboveBar + slotHeight, (int)(imgWidth * this.nidalee.getManaRate()), slotHeight);
        }
        // 图片
        g.drawImage(this.loadImgWeaken(this.nidalee.getImgKeyWord() + ".jpg"), leftBar, aboveBar + 2 * slotHeight, null);
        // 技能图标
        int skillH = aboveBar + 2 * slotHeight + imgHeight;
        g.drawImage(this.loadImgWeaken(this.nidalee.getImgKeyWord() + "Q.jpg"), leftBar, skillH, null);
        g.drawImage(this.loadImgWeaken(this.nidalee.getImgKeyWord() + "W.jpg"), leftBar + skillWidth, skillH, null);
        g.drawImage(this.loadImgWeaken(this.nidalee.getImgKeyWord() + "E.jpg"), leftBar + skillWidth * 2, skillH, null);
        g.drawImage(this.loadImgWeaken("R.jpg"), leftBar + skillWidth * 3, skillH, null);
        // 技能冷却
        g.setColor(Color.BLACK);
        int qCDHeight = (int)(this.nidalee.remainQ() * skillWidth);
        g.fillRect(leftBar, skillH + skillWidth - qCDHeight, skillWidth, qCDHeight);
        int wCDHeight = (int)(this.nidalee.remainW() * skillWidth);
        g.fillRect(leftBar + skillWidth, skillH + skillWidth - wCDHeight, skillWidth, wCDHeight);
        int eCDHeight = (int)(this.nidalee.remainE() * skillWidth);
        g.fillRect(leftBar + skillWidth * 2, skillH + skillWidth - eCDHeight, skillWidth, eCDHeight);
        int rCDHeight = (int)(this.nidalee.remainR() * skillWidth);
        g.fillRect(leftBar + skillWidth * 3, skillH + skillWidth - rCDHeight, skillWidth, rCDHeight);
        // 阵亡文字
        if (this.nidalee.isDeath()) g.drawImage(this.loadImg("death.png"), leftBar + 35, aboveBar + 250, null);
    }

    private class RepaintRunnable implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    View.this.repaint();
                    Thread.sleep(40);
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
            bImage = ImageIO.read(View.class.getClassLoader().getResource("design19/img/" + name));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bImage;
    }

    private BufferedImage loadImgWeaken(String name) {
        BufferedImage bufferedImage = this.loadImg(name);
        if (!this.nidalee.isDeath()) return bufferedImage;
        final int width = 1;
        boolean ifShowY = true;
        int nowY = 0;
        for (int y = 0; y < bufferedImage.getHeight(); y++) {
            if (!ifShowY) {
                for (int x = 0; x < bufferedImage.getWidth(); x++)
                    bufferedImage.setRGB(x, y, 0);
            } else {
                boolean ifShowX = true;
                int nowX = 0;
                for (int x = 0; x < bufferedImage.getWidth(); x++) {
                    if(!ifShowX) bufferedImage.setRGB(x, y, 0);
                    nowX++;
                    if (nowX == width) {
                        nowX = 0;
                        ifShowX = !ifShowX;
                    }
                }
            }
            nowY++;
            if (nowY == width) {
                nowY = 0;
                ifShowY = !ifShowY;
            }
        }
        return bufferedImage;
    }

    private Color getHealthColor() {
        int red;
        int green;
        if (this.nidalee.getHealthRate() >= 0.5) {
            green = 255;
            red = (int)(255 * (1.0 - this.nidalee.getHealthRate()) * 2);
        } else {
            red = 255;
            green = (int)(255 * this.nidalee.getHealthRate() * 2);
        }
        return new Color(red, green, 0);
    }
}