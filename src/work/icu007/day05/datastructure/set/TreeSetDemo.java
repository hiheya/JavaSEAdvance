package work.icu007.day05.datastructure.set;

import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<Student> set = new TreeSet<>();

        set.add(new Student("张三", 24));
        set.add(new Student("王五", 23));
        set.add(new Student("李四", 24));
        set.add(new Student("赵六", 23));

        // 打印set中的元素
        for (Student student : set) {
            System.out.println(student.name + ", " + student.age);
        }
        // TreeSet的特点
        // 1. 元素有序，按照自然顺序排序
        // 2. 元素唯一，不能重复

    }

    static class Student implements Comparable<Student>{
        String name;
        int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int compareTo(Student stu) {
            int result = this.age - stu.age;
            if (result == 0) {
                result = this.name.compareTo(stu.name);
            }
            return result;
        }

    }
}
