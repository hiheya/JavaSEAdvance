package work.icu007.day02.static_app.trait;

/**
 * @Author {xiheya}
 * @Date: 2024/04/11/ 22:29
 * @Description
 */
public class Test01 {
    public static void main(String[] args) {
        // 创建对象
        StaticDemo staticDemo01 = new StaticDemo();
        StaticDemo staticDemo02 = new StaticDemo();
        StaticDemo staticDemo03 = new StaticDemo();

        staticDemo01.NUMBER++;
        staticDemo02.NUMBER++;
        staticDemo03.NUMBER++;

        System.out.println(StaticDemo.NUMBER);
    }
}
