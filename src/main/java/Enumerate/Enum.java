package Enumerate;
import Tools.Tool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: study
 * @description: Java 枚举类
 * @author: Wen lyuzhao
 * @create: 2019-01-24 15:14
 **/


enum Color{
    // red
    RED("红色", 1),
    // green
    GREEN("绿色", 2),
    // blank
    BLANK("白色", 3),
    // yello
    YELLO("黄色", 4);

    // 成员变量
    private String name;
    private int index;

    // 构造方法
    private Color(String name, int index) {
        this.name = name;
        this.index = index;
    }

    // 普通方法
    public static String getName(int index) {
        for (Color c : Color.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }

    // get set 方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

}

// enum Color {
//     // red
//     RED("红色"),
//     // green
//     GREEN("绿色"),
//     // blank
//     BLANK("白色"),
//     // yello
//     YELLO("黄色");
// }

enum SexTwo {
    // male
    MALE("man", 1),
    // female
    FEMALE("woman", 2),

    SHEMALE("ladyboy", 3);

    String alias;
    int num;
    SexTwo(String alias, int num){
        this.alias = alias;
        this.num = num;
    }

}

public class Enum {

    public static void main(String[] args) {

        System.out.println(CityDict.cityId);
        System.out.println(CityDict.cityId.get("薯条"));

    }

}


class CityDict{



    public static Map<String, Integer> cityId = new HashMap<>();

    static {
        String[] content = Tool.readFileText("label_list.txt").split("\n");
        for (int i=0; i < content.length; i++){
            cityId.put(content[i], i);
        }
        System.out.println("initializer...");
    }

    public static void main(String[] args) {
        System.out.println(cityId);
    }
    // private static void setCityId(String[] content){
    //     for (int i=0; i < content.length; i++){
    //         cityId.put(content[i], i);
    //     }
    // }
}