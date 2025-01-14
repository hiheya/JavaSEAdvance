package work.icu007.day05.work;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

/**
 * Test1.
 * <p>
 * 需求：定义一个方法 `int listTest(ArrayList<Integer> list, Integer num)`，要求实现返回num在list里面第一次出现的索引，如果num没出现过返回-1。
 * <p>
 * <p>
 * Test2. 需求：
 * <p>
 * 1. 定义一个学生类Student，包含三个属性姓名、年龄、性别，私有成员变量,生成无参，有参构造方法，生成get/set方法。
 * 2. 创建三个学生对象存入ArrayList集合中。
 * 3. 找出年龄最大的学生，然后将该对象的姓名变为：小猪佩奇。
 * 4. 遍历集合输出对象属性信息。（输出格式如：姓名：张三, 年龄：23, 性别：男）
 * <p>
 * <p>
 * Test3. 请编写main()方法，按以下要求顺序：
 * <p>
 * 1. 定义一个Set集合，并存储以下数据：刘备,关羽,张飞,刘备,张飞
 * 2. 打印集合大小
 * 3. 使用迭代器遍历集合，并打印每个元素
 * 4. 使用增强for遍历集合，并打印每个元素
 * <p>
 * Test4. 请按以下要求顺序编码：
 * <p>
 * 1. 定义学生类Student，属性：姓名、性别、年龄
 * 2. 定义测试类，及main()方法
 * 3. 创建三个Student对象，分别设置以下数据：
 * ```java
 * 张三,男,20
 * 李四,女,21
 * 张三,男,20
 * ```
 * 4. 定义一个存储Student类型的HashSet集合，将上述三个对象存储到Set集合中，要求集合中不能存储姓名,性别,年龄相同的元素。
 * 5. 使用增强for遍历集合，获取集合中每个Student对象，并打印属性值；
 * <p>
 * Test5. 请按以下要求顺序编码：
 * <p>
 * 1. 定义一个可以存储“整数”的LinkedHashSet对象
 * 2. 存储以下整数: 20,30,50,10,30,20
 * 3. 打印集合大小。为什么跟存入的数量不一致？
 * 4. 使用增强for遍历集合，打印大于25的元素
 */
public class Test {
    public static void main(String[] args) {

        System.out.println("==================================Test1==================================");
        // Test1
        // 创建ArrayList集合对象
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        // 调用方法
        int index = listTest(list, 3);
        System.out.println(index);

        System.out.println("==================================Test2==================================");

        // Test2
        // 创建ArrayList集合对象
        ArrayList<Student> list2 = new ArrayList<>();
        list2.add(new Student("张三", 23, "男"));
        list2.add(new Student("李四", 24, "女"));
        list2.add(new Student("王五", 25, "男"));

        // 找出年龄最大的学生
        Student maxStudent = list2.get(0);
        for (int i = 1; i < list2.size(); i++) {
            Student student = list2.get(i);
            if (student.getAge() > maxStudent.getAge()) {
                maxStudent = student;
            }
        }

        // 将该对象的姓名变为：小猪佩奇
        maxStudent.setName("小猪佩奇");

        // 遍历集合输出对象属性信息
        for (Student student : list2) {
            System.out.println("姓名：" + student.getName() + ", 年龄：" + student.getAge() + ", 性别：" + student.getGentle());
        }

        System.out.println("==================================Test3==================================");

        // Test3
        // 创建Set集合对象
        HashSet<String> set = new HashSet<>();
        // LinkedHashSet<String> set = new LinkedHashSet<>();
        // TreeSet<String> set = new TreeSet<>();
        set.add("刘备");
        set.add("关羽");
        set.add("张飞");
        set.add("刘备");
        set.add("张飞");

        // 打印集合大小
        System.out.println(set.size());
        // 使用迭代器遍历集合，并打印每个元素
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            System.out.println(s);
        }

        // 使用增强for遍历集合，并打印每个元素
        for (String s : set) {
            System.out.println(s);
        }

        System.out.println("==================================Test4==================================");

        // Test4
        // 创建HashSet集合对象
        HashSet<Student> set2 = new HashSet<>();
        set2.add(new Student("张三", 20, "男"));
        set2.add(new Student("李四", 21, "女"));
        set2.add(new Student("张三", 20, "男"));

        // 使用增强for遍历集合，获取集合中每个Student对象，并打印属性值
        for (Student student : set2) {
            System.out.println("姓名：" + student.getName() + ", 年龄：" + student.getAge() + ", 性别：" + student.getGentle());
        }

        System.out.println("==================================Test5==================================");

        // Test5
        // 创建LinkedHashSet集合对象
        HashSet<Integer> set3 = new HashSet<>();
        set3.add(20);
        set3.add(30);
        set3.add(50);
        set3.add(10);
        set3.add(30);
        set3.add(20);

        // 打印集合大小
        System.out.println(set3.size());
        // 使用增强for遍历集合，打印大于25的元素
        for (Integer integer : set3) {
            if (integer > 25) {
                System.out.println(integer);
            }
        }

    }

    public static int listTest(ArrayList<Integer> list, Integer num) {
        // 遍历集合
        for (int i = 0; i < list.size(); i++) {
            // 获取元素
            Integer n = list.get(i);
            // 判断元素是否相等
            if (n.equals(num)) {
                return i;
            }
        }
        return -1;
    }

    public static class Student {
        private String name;
        private int age;
        private String gentle;

        public Student() {
        }

        public Student(String name, int age, String gentle) {
            this.name = name;
            this.age = age;
            this.gentle = gentle;
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

        public String getGentle() {
            return gentle;
        }

        public void setGentle(String gentle) {
            this.gentle = gentle;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return age == student.age && Objects.equals(name, student.name) && Objects.equals(gentle, student.gentle);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age, gentle);
        }
    }
}
