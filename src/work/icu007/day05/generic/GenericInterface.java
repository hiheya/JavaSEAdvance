package work.icu007.day05.generic;

public class GenericInterface {
    public static void main(String[] args) {
        GenericInterfaceImpl genericInterface = new GenericInterfaceImpl();
        genericInterface.show("Hello");
    }
}

// 泛型接口的实现类，实现时指定泛型类型
class GenericInterfaceImpl implements GenericInterfaceDemo<String> {
    @Override
    public void show(String s) {
        System.out.println(s);
    }
}

// 泛型接口
interface GenericInterfaceDemo<T> {
    void show(T t);
}
