package work.icu007.day02.interface_app.example;

//男孩（子类）
public class Boy extends Person {
    public Boy(String name, int age) {
        super(name, age);
    }

    @Override
    public void study() {
        System.out.println(super.name + ", " + super.age + "岁, 男孩 不爱学习~");
    }
}
