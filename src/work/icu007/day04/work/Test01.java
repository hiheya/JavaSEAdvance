package work.icu007.day04.work;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 有以下double数组：
 *
 * ```java
 * double[] arr = {0.1,0.2,2.1,3.2,5.56,7.21};
 * ```
 *
 * 请编程计算它们的总值及平均值(四舍五入保留小数点后2位)
 *
 *
 *
 * **思路：**
 *
 * 1. 定义一个BIgDecimal变量用来接收总和
 * 2. 遍历将数组元素都转换为BigDecimal，并累加到总和
 * 3. 打印总和
 * 4. 计算平均值，打印平均值
 */
public class Test01 {
    public static void main(String[] args) {
        double[] arr = {0.1, 0.2, 2.1, 3.2, 5.56, 7.21};
        BigDecimal sum = new BigDecimal(0);
        for (double v : arr) {
            // 如果不加""，会调用BigDecimal(double val)构造方法，会有精度问题
            sum = sum.add(new BigDecimal(v + ""));
        }
        System.out.println("总和：" + sum);

        // 计算平均值

        BigDecimal len = new BigDecimal(arr.length);
        BigDecimal avg = sum.divide(len, 2, RoundingMode.HALF_UP);
        System.out.println("平均值：" + avg);
    }
}
