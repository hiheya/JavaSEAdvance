package work.icu007.day06.set;

import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(100);
        set.add(99);
        set.add(88);
        set.add(66);
        set.add(66);
        System.out.println(set);

        TreeSet<Student> set1 = new TreeSet<>();
        set1.add(new Student("张三",23));
        set1.add(new Student("李四",23));
        System.out.println(set1);
    }
    static class Student implements Comparable<Student> {
        private String name;
        private int age;

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

        @Override
        public String toString() {
            return this.name + this.age;
        }
    }
}
