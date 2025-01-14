package work.icu007.anonymous.base.app;

/**
 * @Author {xiheya}
 * @Date: 2024/04/08/ 22:24
 * @Description
 */
public class Test2 {
    public static void show(Student stu) {
        System.out.println("学生姓名: " + stu.getName());
        System.out.println("学生年龄: " + stu.getAge());
    }

    public static void main(String[] args) {
        Student stu = new Student("张三", 18);
        show(stu);

        // 匿名对象作为方法传递参数
        System.out.println("===============================");
        show(new Student("lisi", 19));
    }
}
