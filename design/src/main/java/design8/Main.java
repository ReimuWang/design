package design8;

import java.io.IOException;

import design8.factory.Factory;
import design8.factory.Page;
import design8.factory.Tray;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, IOException {
        Factory factory = Factory.getListFactory();
        // 创建页面
        Tray tray = factory.createTray(null);
        Page page = factory.createPage("网页导航", tray);
        // 视频网站
        Tray videoTray = factory.createTray("视频网站");
        tray.add(videoTray);
        Tray twoVideoTray = factory.createTray("二次元");
        Tray threeVideoTray = factory.createTray("三次元");
        videoTray.add(twoVideoTray);
        videoTray.add(threeVideoTray);
        twoVideoTray.add(factory.createLink("哔哩哔哩 (゜-゜)つロ 干杯~-bilibili", "https://www.bilibili.com/"));
        twoVideoTray.add(factory.createLink("AcFun弹幕视频网", "http://www.acfun.cn/"));
        threeVideoTray.add(factory.createLink("腾讯视频", "https://v.qq.com/"));
        threeVideoTray.add(factory.createLink("爱奇艺", "http://vip.iqiyi.com/firstsix-new-pc.html"));
        threeVideoTray.add(factory.createLink("优酷", "http://www.youku.com/"));
        // 搜索引擎
        Tray searchTray = factory.createTray("搜索引擎");
        tray.add(searchTray);
        searchTray.add(factory.createLink("百度", "https://www.baidu.com/"));
        searchTray.add(factory.createLink("谷歌", "http://www.google.cn/"));
        // 打印页面
        page.createFile("D:");
    }
}