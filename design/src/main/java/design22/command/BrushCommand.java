package design22.command;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

import design22.view.MyCanvas;

public class BrushCommand implements Command {

    private MyCanvas canvas;

    private int width;

    public BrushCommand(MyCanvas canvas, int width) {
        this.canvas = canvas;
        this.width = width;
    }

    @Override
    public void execute() {
        this.canvas.setR(this.width);
    }

    @Override
    public List<String> strList() {
        List<String> list = new ArrayList<String>(1);
        JSONObject jo = new JSONObject();
        jo.put("type", BrushCommand.class.getName());
        jo.put("brushWidth", this.width);
        list.add(jo.toJSONString());
        return list;
    }
}