package work.icu007.day05.datastructure;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);

        System.out.println(list);

        System.out.println("==============================");

        // ArrayList 的遍历 元素存取有序，有索引且元素可以重复存储
        for (Integer num : list) {
            System.out.println(num);
        }
    }
}
