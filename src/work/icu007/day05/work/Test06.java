package work.icu007.day05.work;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Test06 {
    public static void main(String[] args) {
        Set<String> nameSet = new HashSet<>();
        nameSet.add("刘备");
        nameSet.add("关羽");
        nameSet.add("张飞");
        nameSet.add("刘备");
        nameSet.add("张飞");

        Iterator<String> iterator = nameSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("--------------- \n 增强for循环");
        for (String s : nameSet) {
            System.out.println(s);
        }
    }
}
