package work.icu007.day05.generic;

public class GenericMethod {
    public static void main(String[] args) {
        // 调用泛型方法时，指定泛型类型
        show(1);
        show("Hello");
        show(1.1);
        show(true);
        show('a');
        show(1L);
        show(1.1F);
        show(1.1D);
    }

    // 设计一个泛型方法
    public static <T> void show(T t) {
        System.out.println(t + " 的类型是：" + t.getClass().getName());
    }
}
