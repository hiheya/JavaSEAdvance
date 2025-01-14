package work.icu007.day04.work;

import java.util.Collection;
import java.util.ArrayList;

/**
 * 请定义一个Collection类型的集合，存储以下分数信息：
 *
 * ```java
 * 88.5,39.2,77.1,56.8,89,99,59.5
 * ```
 *
 * 请编程实现以下功能：
 *
 * - 使用增强for遍历所有元素，并打印
 * - 使用增强for遍历所有元素，打印不及格的分数；
 * - 使用增强for遍历所有元素，计算不及格的分数的数量，和平均分，并打印计算结果。
 * - 使用增强for遍历所有元素，求出最高分，并打印；
 *
 *
 * (注意：以上所有功能写在一个main()方法中，但请单独实现)
 */
public class Test06 {
    public static void main(String[] args) {
        Collection<Double> collection = new ArrayList<>();
        collection.add(88.5);
        collection.add(39.2);
        collection.add(77.1);
        collection.add(56.8);
        collection.add(89.0);
        collection.add(99.0);
        collection.add(59.5);

        // 使用增强for遍历所有元素，并打印
        for (Double score : collection) {
            System.out.println(score);
        }

        System.out.println("===============================");

        // 使用增强for遍历所有元素，打印不及格的分数；
        for (Double score : collection) {
            if (score < 60) {
                System.out.println(score);
            }
        }

        System.out.println("===============================");

        // 使用增强for遍历所有元素，计算不及格的分数的数量，和平均分，并打印计算结果。
        int count = 0;
        double sum = 0;
        for (Double score : collection) {
            if (score < 60) {
                count++;
                sum += score;
            }
        }
        System.out.println("不及格的分数数量：" + count);
        System.out.println("不及格的分数平均分：" + sum / count);

        System.out.println("===============================");

        // 使用增强for遍历所有元素，求出最高分，并打印；
        double max = 0;
        for (Double score : collection) {
            if (score > max) {
                max = score;
            }
        }
        System.out.println("最高分：" + max);
    }
}
