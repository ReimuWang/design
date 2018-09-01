package design18;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class View extends Frame {

    private static final long serialVersionUID = 1L;

    private Subject subject;

    private List<Memento> snapshotList = new ArrayList<Memento>();

    public View(Subject subject) {
        this.subject = subject;
    }

    public void launchFrame() {
        super.setLocation(700, 300);
        super.setSize(200, 150);
        super.setTitle(this.subject.getName());
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
                    case KeyEvent.VK_UP:
                        System.out.println("上箭头被按下，加分。");
                        View.this.snapshotList.add(View.this.subject.createSnapshot());
                        View.this.subject.setScore(View.this.subject.getScore() + 1);
                        break;
                    case KeyEvent.VK_DOWN:
                        System.out.println("下箭头被按下，减分。");
                        View.this.snapshotList.add(View.this.subject.createSnapshot());
                        View.this.subject.setScore(View.this.subject.getScore() - 1);
                        break;
                    case KeyEvent.VK_LEFT:
                        System.out.println("左箭头被按下，撤销上一次操作。");
                        if (View.this.snapshotList.size() > 0) {
                            Memento lastMemento = View.this.snapshotList.get(View.this.snapshotList.size() - 1);
                            View.this.snapshotList.remove(View.this.snapshotList.size() - 1);
                            View.this.subject.recovery(lastMemento);
                        }
                        break;
                    case KeyEvent.VK_RIGHT:
                        System.out.println("右箭头被按下，在控制台中打印当前存储的快照。");
                        System.out.println("============================");
                        for (int i = 0; i < View.this.snapshotList.size(); i++)
                            System.out.println(i + "---" + View.this.snapshotList.get(i));
                        System.out.println("============================");
                        break;
                    default:
                        System.out.println("非法按键，键值=" + e.getKeyCode());
                    }
                }
            }
        );
        super.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        g.setFont(new Font(null, Font.BOLD, 30));
        g.drawString("" + View.this.subject.getScore(), 50, 100);
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
}