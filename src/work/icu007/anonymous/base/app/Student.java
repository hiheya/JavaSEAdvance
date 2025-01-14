package work.icu007.anonymous.base.app;

/**
 * @Author {xiheya}
 * @Date: 2024/04/08/ 22:09
 * @Description
 */
public class Student {
    private String name;
    private int age;
    public Student(){

    }
    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void study() {
        System.out.println("学习方法");
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
