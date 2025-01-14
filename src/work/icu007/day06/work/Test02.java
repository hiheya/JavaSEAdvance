package work.icu007.day06.work;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test02 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);
        System.out.println("------------- \n 打乱：");
        Collections.shuffle(list);
        System.out.println(list);
        System.out.println("------------- \n 升序：");
        Collections.sort(list);
        System.out.println(list);
        System.out.println("------------- \n 降序：");
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(list);
    }
}
