package work.icu007.anonymous.base.app;

/**
 * @Author {xiheya}
 * @Date: 2024/04/08/ 22:22
 * @Description
 */
public class Test {
    public static void main(String[] args) {
        Student student = new Student();
        student.study();

        // 当只使用对象中的某个方法一次时,使用匿名对象
        new Student().study();
    }
}
