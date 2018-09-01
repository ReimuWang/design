package design7;

import java.io.IOException;

public class Designer {

    public void construct(Builder builder, String path, String title) throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, IOException {
        builder.bulidHead(title);
        builder.bulidTitle("红魔馆");
        builder.bulidString("红魔馆（こうまかん/Koumakan）是蕾米莉亚·斯卡雷特拥有的一间房子。它位于雾之湖的边缘。从外面可以看见深红色的窗户，但是窗户并不多，因为吸血鬼不喜欢阳光。里面也有很多没有窗户的房间。屋顶上有一个钟楼，但钟只在晚上敲响。红魔馆内部比外面看起来大得多。");
        builder.bulidString("主要成员：");
        builder.bulidItems(new String[] {
                           "蕾米莉亚·斯卡雷特（レミリア·スカーレット/Remilia Scarlet）",
                           "芙兰朵露·斯卡雷特（フランドール·スカーレット/Flandre Scarlet）",
                           "十六夜咲夜（いざよい さくや/Sakuya Izayoi）",
                           "帕秋莉·诺蕾姬（パチュリー·ノーレッジ/Patchouli Knowledge）",
                           "小恶魔（リートル デビッル/Little Devil）",
                           "红美铃（ホン メイリン/Hong Meirin）"
        });
        builder.bulidTitle("永远亭");
        builder.bulidString("永远亭是《东方project》中位于迷途竹林深处的一座日式建筑，是八意永琳、蓬莱山辉夜、因幡帝和铃仙·优昙华院·因幡的居住地。首次出现在《东方永夜抄》。");
        builder.bulidString("主要成员：");
        builder.bulidItems(new String[] {
                           "蓬莱山辉夜（ほうらいさん かぐや/Houraisan Kaguya）",
                           "八意永琳(やごころ えいりん/Eirin Yagokoro)",
                           "铃仙·优昙华院·因幡（レイセン・うどんげいん・イナバ/Reisen Udongein Inaba）",
                           "因幡帝（いなば てゐ/Tewi Inaba）"
        });
        builder.bulidTitle("白玉楼");
        builder.bulidString("白玉楼（はくぎょくろう/Hakugyokurou）是《东方project》中位于冥界的一座有着庭院的屋子，是西行寺幽幽子和魂魄妖梦的居住地。首次出现在《东方妖妖梦》。");
        builder.bulidString("主要成员：");
        builder.bulidItems(new String[] {
                           "西行寺幽幽子（さいぎょうじ　ゆゆこ/Saigyouji Yuyuko）",
                           "魂魄 妖梦(こんぱく　ようむ/Youmu Konpaku)"
        });
        builder.createFile(path + title);
    }
}