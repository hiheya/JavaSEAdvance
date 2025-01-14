package work.icu007.day03.work;

import java.util.Objects;

/*
请按标准格式定义一个“学生类”，它有三个属性：姓名、性别、年龄。

要求：在测试类主方法中完成

1. 创建学生对象打印对象时，不再是地址，而是能够将对象的属性内容打印出来。
2. 两个学生类的对象比较时，要求姓名，性别，年龄属性值相同即认为这两个学生对象是相同的。
 */
public class Test03 {
    public static void main(String[] args) {
        Student student1 = new Student
                ("张三", "男", 18);
        Student student2 = new Student
                ("张三", "男", 18);
        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student1.equals(student2));

    }
}

class Student {
    private String name;
    private String gender;
    private int age;

    public Student(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ",gender= " + gender + '\'' +
                ",age= " + age + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Student student = (Student) obj;
        return age == student.age && Objects.equals(name ,student.name) && Objects.equals(gender, student.gender);

    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender, age);
    }
}
