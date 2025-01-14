package work.icu007.day06.work;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test05 {
    public static void main(String[] args) {
        HashMap<Integer, String> personHashMap = new HashMap<>();
        personHashMap.put(1, "zs");
        personHashMap.put(2, "ls");
        personHashMap.put(3, "ww");

        System.out.println("集合大小：" + personHashMap.size());
        System.out.println("-------------- \n 键找值：");
        Set<Integer> keySet = personHashMap.keySet();
        for (Integer i : keySet) {
            System.out.println("key:" + i + " value: " + personHashMap.get(i));
        }

        System.out.println("-------------- \n 键值对：");
        Set<Map.Entry<Integer, String>> entries = personHashMap.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
        }

        System.out.println("获取键值为1的值" + personHashMap.get(1));
        System.out.println("获取键值为10的值" + personHashMap.get(10));
        System.out.println("是否有键 10：" + personHashMap.containsKey(10));
        System.out.println("删除键为1的键值对");
        personHashMap.remove(1);
        System.out.println(personHashMap);
    }
}
