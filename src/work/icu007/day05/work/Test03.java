package work.icu007.day05.work;

import java.util.ArrayList;
import java.util.Iterator;

public class Test03 {
    public static void main(String[] args) {
        ArrayList<Integer> intArray = new ArrayList<>();

        intArray.add(2);
        intArray.add(4);
        intArray.add(3);
        intArray.add(5);

        for (int i = 0; i < intArray.size(); i++) {
            System.out.println(intArray.get(i));
        }

        System.out.println("----------------\n 增强for循环");
        for (Integer i : intArray) {
            System.out.println(i);
        }

        System.out.println("----------------\n 迭代器");
        Iterator<Integer> iterator = intArray.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
