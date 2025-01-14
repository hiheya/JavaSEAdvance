package work.icu007.day02.static_app.trait;

/**
 * @Author {xiheya}
 * @Date: 2024/04/11/ 22:31
 * @Description
 */
// 静态内容是不需要创建对象就可使用的,早于对象创建
public class Test02 {
    public static void main(String[] args) {
        System.out.println(StaticDemo.NUMBER);
        StaticDemo.method();
    }
}
