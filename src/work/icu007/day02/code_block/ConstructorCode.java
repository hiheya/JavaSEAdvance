package work.icu007.day02.code_block;

import java.util.ArrayList;

/**
 * @Author {xiheya}
 * @Date: 2024/04/13/ 23:22
 * @Description
 */
public class ConstructorCode {
    ArrayList<String> list = new ArrayList<String>();

    {
        System.out.println("构造代码块~~~");
        //把构造方法中共性内容书写在构造代码块中
        list.add("Java");
        list.add("MySQL");
        list.add("HTML");
    }

    // 构造方法
    public ConstructorCode() {
        System.out.println("无参构造方法");
    }

    public ConstructorCode(String str) {
        System.out.println("有参构造方法");
        list.add(str);
    }
}
