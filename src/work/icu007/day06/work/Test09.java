package work.icu007.day06.work;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Test09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入：");
        String string = scanner.nextLine();
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (char c : string.toCharArray()) {
            if (hashMap.containsKey(c)) {
                hashMap.put(c, hashMap.get(c) + 1);
            } else {
                hashMap.put(c, 1);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        Set<Character> keySet = hashMap.keySet();
        for (Character c : keySet) {
            stringBuilder.append(c).append("(").append(hashMap.get(c)).append(")");
        }

        System.out.println(stringBuilder);
    }
}
