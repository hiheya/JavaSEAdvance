package work.icu007.day02.work;

/**
 * @Author Charlie_Liam
 * @Date: 2024/04/14/ 13:13
 * @Description
 */
/*
创建一个类学生类，定义属性姓名，年龄，性别。要求性别使用枚举类型只能是男或者女两种值。
 */
public class Student {
    private String name;
    private Gender gender;
    private int age;

    public Student(String name, Gender gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }
}
