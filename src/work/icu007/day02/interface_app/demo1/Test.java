package work.icu007.day02.interface_app.demo1;

/**
 * @Author Charlie_Liam
 * @Date: 2024/04/14/ 0:14
 * @Description
 */
public class Test {
    public static void main(String[] args) {
        MyInterfaceImpl mi = new MyInterfaceImpl();
        String result = mi.sayHello("李四");
        System.out.println(result);
    }
}
