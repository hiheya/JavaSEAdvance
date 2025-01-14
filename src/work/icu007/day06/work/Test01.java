package work.icu007.day06.work;

import java.util.Comparator;
import java.util.Random;
import java.util.TreeSet;

public class Test01 {
    public static void main(String[] args) {
        TreeSet<Integer> integerTreeSet = new TreeSet<>();
        TreeSet<Integer> integerTreeSet1 = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int index = 0;
        int index1 = 0;
        while (index < 10 && index1 <= 10) {
            int num = new Random().nextInt(51);
            if (!integerTreeSet.contains(num)) {
                integerTreeSet.add(num);
                index++;
            }

            int num1 = 50 + new Random().nextInt(51);
            if (!integerTreeSet1.contains(num1)) {
                integerTreeSet1.add(num1);
                index1++;
            }
        }
        System.out.println(integerTreeSet);
        System.out.println(integerTreeSet1);
    }
}
