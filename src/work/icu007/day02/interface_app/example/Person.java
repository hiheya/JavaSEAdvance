package work.icu007.day02.interface_app.example;

//人（抽象类）
public abstract class Person {
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
//共性内容：属性、行为

    //属性：
    public String name;//姓名
    public int age;//年龄

    //行为：
    public abstract void study();
}
