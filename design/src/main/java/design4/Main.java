package design4;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Role> roleList = new ArrayList<Role>(5);
        RoleFactory roleFactory = new HumanFactory();
        roleList.add(roleFactory.create("博丽灵梦"));
        roleList.add(roleFactory.create("雾雨魔理沙"));
        roleList.add(roleFactory.create("十六夜咲夜"));
        roleFactory = new VampireFactory();
        roleList.add(roleFactory.create("蕾米莉亚·斯卡雷特"));
        roleList.add(roleFactory.create("芙兰朵露·斯卡蕾特"));
        for (Role role : roleList) System.out.println(role);
    }
}