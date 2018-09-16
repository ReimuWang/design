package design22.command;

import java.awt.Color;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSONObject;

import design22.view.MyCanvas;

public class MacroCommand implements Command {

    private Stack<Command> commands = new Stack<Command>();

    private static final String SAVE = "src/main/java/design22/save/save.txt";

    private static final String ENCODING = "UTF-8";

    private MyCanvas canvas;

    public MacroCommand(MyCanvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void execute() {
        Iterator<Command> iterator = this.commands.iterator();
        while (iterator.hasNext()) iterator.next().execute();
    }

    public void append(Command cmd) {
        if (this != cmd) this.commands.push(cmd);
    }

    public void clear() {
        this.commands.clear();
    }

    public void undo() {
        if (!this.commands.isEmpty()) this.commands.pop();
    }

    public void save() {
        List<String> data = this.strList();
        FileOutputStream fo = null;
        OutputStreamWriter ow = null;
        BufferedWriter bw = null;
        try {
            fo = new FileOutputStream(new File(MacroCommand.SAVE));
            ow = new OutputStreamWriter(fo, MacroCommand.ENCODING);
            bw = new BufferedWriter(ow);
            for (String str : data) {
                bw.write(str);
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
                ow.close();
                fo.close();
            } catch (Exception ef) {
                ef.printStackTrace();
            }
        }
    }

    @Override
    public List<String> strList() {
        List<String> list = new ArrayList<String>();
        Iterator<Command> iterator = this.commands.iterator();
        while (iterator.hasNext()) list.addAll(iterator.next().strList());
        return list;
    }

    public void load() {
        this.clear();
        this.canvas.init();
        FileInputStream fi = null;
        InputStreamReader ir = null;
        BufferedReader br = null;
        try {
            fi = new FileInputStream(new File(MacroCommand.SAVE));
            ir = new InputStreamReader(fi, MacroCommand.ENCODING);
            br = new BufferedReader(ir);
            String lineTxt = null;
            while (!StringUtils.isBlank((lineTxt = br.readLine()))) {
                JSONObject jo = JSONObject.parseObject(lineTxt);
                String className = jo.get("type").toString();
                Command cmd = null;
                if (DrawCommand.class.getName().equals(className)) {
                    cmd = new DrawCommand(this.canvas, new Point(Integer.parseInt(jo.get("pointX").toString()), Integer.parseInt(jo.get("pointY").toString())));
                } else if (ColorCommand.class.getName().equals(className)) {
                    cmd = new ColorCommand(this.canvas, new Color(Integer.parseInt(jo.get("colorRGB").toString())));
                } else if (BrushCommand.class.getName().equals(className)) {
                    cmd = new BrushCommand(this.canvas, Integer.parseInt(jo.get("brushWidth").toString()));
                }
                if (null != cmd) this.append(cmd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                ir.close();
                fi.close();
            } catch (Exception ef) {
                ef.printStackTrace();
            }
        }
    }
}