package work.icu007.day02.interface_app.demo3;

/**
 * @Author Charlie_Liam
 * @Date: 2024/04/14/ 0:52
 * @Description
 */
public interface Jdk8Interface {
    // 常量
    int COUNT = 10;

    // 抽象方法
    void method();

    // 默认方法 必须有default关键字 (仅限在接口中书写)
    default String sayHello(String name) {
        return "你好, " + name;
    }

    static String hello(String msg) {
        return "msg: " + msg;
    }
}
