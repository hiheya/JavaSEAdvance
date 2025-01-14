package work.icu007.day02.work;

/*
定义一个数学工具类，类名使用MyMath。

要求：

1. 该工具类不能有子类，不接受扩展。
2. 该工具类不能被外界创建对象，构造方法需要私有化。
3. 定义静态常量：PI，用来保存圆周率：3.14。
4. 定义静态方法max，获取两个整数的较大值。
5. 定义静态方法min，获取两个整数的较小值。
 */
public final class MathUtil {
    public final double PI = 3.14;

    private MathUtil() {

    }

    public static int max(int a, int b) {
        return a > b ? a : b;
    }
    public static int min(int a, int b) {
        return a < b ? a : b;
    }

}
