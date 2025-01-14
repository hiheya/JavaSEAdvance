package work.icu007.day02.code_block;

import java.util.ArrayList;

/**
 * @Author Charlie_Liam
 * @Date: 2024/04/13/ 23:29
 * @Description
 */
public class StaticCode {
    static ArrayList<String> list = new ArrayList<String>();
    static {
        System.out.println("静态代码块");

        list.add("Java");
        list.add("MySQL");
        list.add("MyBatis");
        list.add("Html");
    }
    public static String getData(int index) {
        return list.get(index);
    }
}
