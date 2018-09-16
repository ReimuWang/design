package design22.command;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

import design22.view.MyCanvas;

public class ColorCommand implements Command {

    private MyCanvas canvas;

    private Color color;

    public ColorCommand(MyCanvas canvas, Color color) {
        this.canvas = canvas;
        this.color = color;
    }

    @Override
    public void execute() {
        this.canvas.setColor(this.color);
    }

    @Override
    public List<String> strList() {
        List<String> list = new ArrayList<String>(1);
        JSONObject jo = new JSONObject();
        jo.put("type", ColorCommand.class.getName());
        jo.put("colorRGB", this.color.getRGB());
        list.add(jo.toJSONString());
        return list;
    }
}