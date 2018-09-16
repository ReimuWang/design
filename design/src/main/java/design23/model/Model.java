package design23.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.apache.commons.lang.StringUtils;

import design23.model.entity.GameMap;
import design23.model.parse.Context;
import design23.model.parse.ParseException;
import design23.model.parse.ProgramNode;

public class Model {

    private GameMap map;

    private ProgramNode root = new ProgramNode();

    public void initMap(int row, int column, int stageCount, int focusR, int focusC, int direction) {
        this.map = new GameMap(row, column, stageCount, focusR, focusC, direction);
    }

    public void initInterpreter(String path) {
        try {
            this.root.parse(new Context(this.loadCode(path)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(this.root);
    }

    public void exe() {
        new Thread() {
            @Override
            public void run() {
                Model.this.root.exe(Model.this.map);
            }
        }.start();
    }

    public GameMap getMap() {
        return map;
    }

    private String loadCode(String path) {
        StringBuilder sb = new StringBuilder();
        FileInputStream fi = null;
        InputStreamReader ir = null;
        BufferedReader br = null;
        try {
            fi = new FileInputStream(new File(path));
            ir = new InputStreamReader(fi, "UTF-8");
            br = new BufferedReader(ir);
            String lineTxt = null;
            while (!StringUtils.isBlank((lineTxt = br.readLine())))
                sb.append(lineTxt).append(" ");
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
        return sb.toString();
    }
}