package work.icu007.day02.interface_app.demo2;

/**
 * @Author Charlie_Liam
 * @Date: 2024/04/14/ 0:19
 * @Description
 */
public class MyInterfaceImpl implements MyInterfaceA, MyInterfaceB{
    @Override
    public void show() {
        System.out.println("getData: " + getData());
    }

    @Override
    public int getData() {
        return 9527;
    }
}
