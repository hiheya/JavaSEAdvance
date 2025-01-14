package work.icu007.day05.generic;

public class GenericClass {
    public static void main(String[] args) {
        // 在创建对象的时候指定泛型类型
        Demo<String> demo = new Demo<>("Hello");
        System.out.println(demo);
    }
}

// 泛型类
class Demo<T> {
    private T t;

    public Demo() {
    }

    public Demo(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "t=" + t +
                '}';
    }
}
