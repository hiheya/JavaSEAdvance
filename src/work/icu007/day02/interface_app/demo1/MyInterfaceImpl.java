package work.icu007.day02.interface_app.demo1;

/**
 * @Author Charlie_Liam
 * @Date: 2024/04/14/ 0:12
 * @Description
 */
public class MyInterfaceImpl implements MyInterface{
    @Override
    public String sayHello(String name) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(name);
        stringBuffer.append(" hello");
        return stringBuffer.toString();
    }
}
