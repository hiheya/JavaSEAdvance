package work.icu007.day05.work;

import java.util.ArrayList;

public class Test04 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(3);

        System.out.println(listTest(list, 1));
    }

    public static int listTest(ArrayList<Integer> list, Integer num) {
        for (int i = 0; i < list.size(); i++) {
            if (num.equals(list.get(i))) return i;
        }
        return -1;
    }
}
