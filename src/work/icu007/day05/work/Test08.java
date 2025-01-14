package work.icu007.day05.work;

import java.util.LinkedHashSet;

public class Test08 {
    public static void main(String[] args) {
        LinkedHashSet<Integer> integerLinkedHashSet = new LinkedHashSet<>();

        integerLinkedHashSet.add(20);
        integerLinkedHashSet.add(30);
        integerLinkedHashSet.add(50);
        integerLinkedHashSet.add(10);
        integerLinkedHashSet.add(30);
        integerLinkedHashSet.add(20);
        System.out.println("the integerLinkedHashSet.size() is " + integerLinkedHashSet.size());

        System.out.println(integerLinkedHashSet);

        for (Integer num : integerLinkedHashSet) {
            if (num > 25) System.out.println(num);
        }
    }
}
