package design22.command;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

import design22.view.MyCanvas;

public class DrawCommand implements Command {

    private MyCanvas canvas;

    private Point point;

    public DrawCommand(MyCanvas canvas, Point point) {
        this.canvas = canvas;
        this.point = point;
    }

    @Override
    public void execute() {
        this.canvas.draw(this.point);
    }

    @Override
    public List<String> strList() {
        List<String> list = new ArrayList<String>(1);
        JSONObject jo = new JSONObject();
        jo.put("type", DrawCommand.class.getName());
        jo.put("pointX", this.point.x);
        jo.put("pointY", this.point.y);
        list.add(jo.toJSONString());
        return list;
    }
}