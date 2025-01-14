package work.icu007.anonymous.base.app;

/**
 * @Author {xiheya}
 * @Date: 2024/04/08/ 22:36
 * @Description
 */
public class Test3 {
    // 匿名对象作为方法的返回值
    public static Student createStudent(String name, int age) {
        return new Student(name, age);
    }

    public static void main(String[] args) {
        Student stu = createStudent("光头强", 50);
        System.out.println(stu.getName());
    }
}
