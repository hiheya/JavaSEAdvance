package work.icu007.day02.interface_app.demo2;

/**
 * @Author Charlie_Liam
 * @Date: 2024/04/14/ 0:16
 * @Description
 */
public interface MyInterfaceA {
    // 在接口中书写抽象方法时可以省略: public abstract
    void show();    // 在javac编译代码时.会把接口中的方法补全: public abstract void show()
}
