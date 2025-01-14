package work.icu007.day02.work;

/**
 * @Author Charlie_Liam
 * @Date: 2024/04/14/ 12:18
 * @Description
 */
/*
定义一个数学工具类，类名使用MyMath。

要求：

1. 该工具类不能有子类，不接受扩展。
2. 该工具类不能被外界创建对象，构造方法需要私有化。
3. 定义静态常量：PI，用来保存圆周率：3.14。
4. 定义静态方法max，获取两个整数的较大值。
5. 定义静态方法min，获取两个整数的较小值。
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("======================题目1======================");
        // 题目1
        int max = MathUtil.max(3, 8);
        int min = MathUtil.min(3, 8);
        System.out.println("3和8 中 min: " + min + " max: " + max);

        System.out.println("======================题目2======================");
        // 题目2
        JavaLecturer javaLecturer = new JavaLecturer("张三", "男", 28);
        UILecturer uiLecturer = new UILecturer("李四", "女", 28);
        javaLecturer.work();
        uiLecturer.work();
        uiLecturer.painting();

        System.out.println("======================题目3======================");
        // 题目3
        Circle circle = new Circle(2.0);
        double area = circle.getArea();
        double circumference = circle.getCircumference();
        circle.show();
        System.out.println("周长为: " + area + " 面积为: " + circumference);

        System.out.println("======================题目4======================");
        // 题目4
       new Bus().charge();
       new Taxi().charge();
       new Cinema().charge();

        System.out.println("======================题目5======================");
        // 题目5
        System.out.println(Week.MONDAY);

        System.out.println("======================题目6======================");
        // 题目6
        Student xiaoMing = new Student("小明", Gender.BOY, 18);
        Student xiaoHong = new Student("小红", Gender.GIRL, 19);
        System.out.println(xiaoMing);
        System.out.println(xiaoHong);
    }
}

