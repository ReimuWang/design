package design22.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

import design22.command.BrushCommand;
import design22.command.ColorCommand;
import design22.command.Command;
import design22.command.DrawCommand;

public class View extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    MyCanvas canvas = new MyCanvas(50 * 16, 50 * 9);

    private int maxBrush = 20;

    private List<JCheckBox> brushBoxs = new ArrayList<JCheckBox>();

    private List<ColorBox> colorBoxs = new ArrayList<ColorBox>();

    private List<JButton> buttons = new ArrayList<JButton>();

    public View() {
        // 制作按钮
        this.buttons.add(new JButton("清空"));
        this.buttons.add(new JButton("撤销"));
        this.buttons.add(new JButton("保存"));
        this.buttons.add(new JButton("读取"));
        for (JButton button : this.buttons) button.addActionListener(this);
        // 制作颜色CheckBox
        this.colorBoxs.add(new ColorBox(Color.BLACK, "黑", this));
        this.colorBoxs.add(new ColorBox(Color.DARK_GRAY, "深灰", this));
        this.colorBoxs.add(new ColorBox(Color.GRAY, "灰", this));
        this.colorBoxs.add(new ColorBox(Color.LIGHT_GRAY, "浅灰", this));
        this.colorBoxs.add(new ColorBox(Color.BLUE, "蓝", this));
        this.colorBoxs.add(new ColorBox(Color.CYAN, "青", this));
        this.colorBoxs.add(new ColorBox(Color.GREEN, "绿", this));
        this.colorBoxs.add(new ColorBox(Color.MAGENTA, "洋红", this));
        this.colorBoxs.add(new ColorBox(Color.RED, "红", this));
        this.colorBoxs.add(new ColorBox(Color.PINK, "粉", this));
        this.colorBoxs.add(new ColorBox(Color.ORANGE, "橘", this));
        this.colorBoxs.add(new ColorBox(Color.YELLOW, "黄", this));
        ButtonGroup colorGroup = new ButtonGroup();
        for (ColorBox colorBox : this.colorBoxs) {
            colorBox.checkBox.addActionListener(this);
            colorGroup.add(colorBox.checkBox);
        }
        // 制作画笔CheckBox
        ButtonGroup brushGroup = new ButtonGroup();
        for (int i = 1; i <= this.maxBrush; i++) {
            JCheckBox brushCheckBox = new JCheckBox(i + "", i == this.canvas.r);
            this.brushBoxs.add(brushCheckBox);
            brushCheckBox.addActionListener(this);
            brushGroup.add(brushCheckBox);
        }
        // 画布拖动监听
        this.canvas.addMouseMotionListener(
            new MouseMotionAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    Command cmd = new DrawCommand(View.this.canvas, e.getPoint());
                    View.this.canvas.history.append(cmd);
                    cmd.execute();
                }
            }
        );
        // 布局
        Box firstBox = new Box(BoxLayout.X_AXIS);
        for (JButton button : this.buttons) firstBox.add(button);
        Box secondBox = new Box(BoxLayout.X_AXIS);
        Box brushBox = new Box(BoxLayout.Y_AXIS);
        for (JCheckBox temp : this.brushBoxs) brushBox.add(temp);
        secondBox.add(brushBox);
        secondBox.add(this.canvas);
        Box colorBox = new Box(BoxLayout.Y_AXIS);
        for (ColorBox temp : this.colorBoxs) colorBox.add(temp.checkBox);
        secondBox.add(colorBox);
        Box mainBox = new Box(BoxLayout.Y_AXIS);
        mainBox.add(firstBox);
        mainBox.add(secondBox);
        super.getContentPane().add(mainBox);
        // 关闭
        this.addWindowListener(
            new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        // 显示
        super.pack();
        super.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (JButton button : this.buttons) {
            if (e.getSource() == button) {
                if ("清空".equals(button.getText())) {
                    this.canvas.history.clear();
                    this.canvas.repaint();
                } else if ("撤销".equals(button.getText())) {
                    this.canvas.history.undo();
                    this.canvas.repaint();
                } else if ("保存".equals(button.getText())) {
                    this.canvas.history.save();
                } else if ("读取".equals(button.getText())) {
                    this.canvas.history.load();
                    this.canvas.repaint();
                }
                return;
            }
        }
        for (ColorBox colorBox : this.colorBoxs) {
            if (e.getSource() == colorBox.checkBox) {
                Command cmd = new ColorCommand(this.canvas, colorBox.color);
                this.canvas.history.append(cmd);
                cmd.execute();
                return;
            }
        }
        for (JCheckBox brushBox : this.brushBoxs) {
            if (e.getSource() == brushBox) {
                Command cmd = new BrushCommand(this.canvas, Integer.parseInt(brushBox.getText()));
                this.canvas.history.append(cmd);
                cmd.execute();
                return;
            }
        }
    }
}

class ColorBox {

    Color color;

    JCheckBox checkBox;

    String desc;

    ColorBox (Color color, String desc, View view) {
        this.color = color;
        this.checkBox = new JCheckBox(desc, this.color == view.canvas.color);
    }
}