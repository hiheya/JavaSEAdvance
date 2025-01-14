package work.icu007.day02.enum_app.base;

/**
 * @Author Charlie_Liam
 * @Date: 2024/04/14/ 1:58
 * @Description
 */
public class Test {
    public static void main(String[] args) {
        change(Signal.GREEN);
        change(Signal.YELLOW);
        change(Signal.RED);
    }

    private static void change(Signal color) {
        switch (color) {
            case RED -> System.out.println("红灯停");
            case YELLOW -> System.out.println("黄灯等一等");
            case GREEN -> System.out.println("绿灯行");
        }
    }
}
