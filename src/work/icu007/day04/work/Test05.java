package work.icu007.day04.work;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 请定义一个Collection类型的集合，存储以下字符串：
 *
 * ```
 *   "JavaEE企业级开发指南"
 *   "Oracle高级编程"
 *   "MySQL从入门到精通"
 *   "Java架构师之路"
 * ```
 *
 * 请编程实现以下功能：
 *
 * - 使用迭代器遍历所有元素，并打印
 * - 使用迭代器遍历所有元素，筛选书名小于10个字符的，并打印；
 * - 使用迭代器遍历所有元素，筛选书名中包含“Java”的，并打印
 * - 如果书名中包含“Oracle”，则删掉此书。删掉后，遍历集合，打印所有书名。
 *
 *        (注意：以上功能写在一个main()方法中，但请单独实现)
 */
public class Test05 {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("JavaEE企业级开发指南");
        collection.add("Oracle高级编程");
        collection.add("MySQL从入门到精通");
        collection.add("Java架构师之路");

        // 使用迭代器打印所有字符
        Iterator<String> iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("===============================");

        // 使用迭代器遍历所有元素，筛选书名小于10个字符的，并打印；
        Iterator<String> iterator1 = collection.iterator();
        while (iterator1.hasNext()) {
            String next = iterator1.next();
            if (next.length() < 10) {
                System.out.println(next);
            }
        }
        System.out.println("===============================");

        // 使用迭代器遍历所有元素，筛选书名中包含“Java”的，并打印
        Iterator<String> iterator2 = collection.iterator();
        while (iterator2.hasNext()) {
            String next = iterator2.next();
            if (next.contains("Java")) {
                System.out.println(next);
            }
        }
        System.out.println("===============================");

        // 如果书名中包含“Oracle”，则删掉此书。删掉后，遍历集合，打印所有书名。
        Iterator<String> iterator3 = collection.iterator();
        while (iterator3.hasNext()) {
            String next = iterator3.next();
            if (next.contains("Oracle")) {
                iterator3.remove();
            }
        }
        Iterator<String> iterator4 = collection.iterator();
        while (iterator4.hasNext()) {
            System.out.println(iterator4.next());
        }
    }
}
