package work.icu007.day02.interface_app.example;

//女孩（子类）
public class Girl extends Person {
    public Girl(String name, int age) {
        super(name, age);
    }

    @Override
    public void study() {
        System.out.println(super.name + ", " + super.age + "岁, 女孩 爱学习!");
    }
}
