package work.icu007.day02.interface_app.demo3;

/**
 * @Author Charlie_Liam
 * @Date: 2024/04/14/ 0:56
 * @Description
 */
public class Test {
    public static void main(String[] args) {
        Jdk8InterfaceImpl jdk8Interface = new Jdk8InterfaceImpl();
        String result = jdk8Interface.sayHello("张三");
        System.out.println(result);
        String hello_world = Jdk8Interface.hello("hello world");
        System.out.println(hello_world);
    }
}
