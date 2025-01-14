package work.icu007.day05.generic;

import java.util.ArrayList;

public class Wildcard {
    public static void main(String[] args) {
        ArrayList<Person> list1 = new ArrayList<>();
        ArrayList<Student> list2 = new ArrayList<>();
        ArrayList<Worker> list3 = new ArrayList<>();
        method(list1);
        method(list2);
        method(list3);

        ArrayList<Integer> list4 = new ArrayList<>();
        list4.add(1);
        list4.add(2);
        list4.add(3);
        sum(list4);

        ArrayList<Double> list5 = new ArrayList<>();
        list5.add(1.1);
        list5.add(2.2);
        list5.add(3.3);
        sum(list5);

    }

    public static void method(ArrayList<?> list) {
        // 通配符的上限
        // List<? extends Person> list
        // 通配符的下限
        // List<? super Person> list
    }

    public static void sum(ArrayList<? extends Number> list) {
        // 计算list中元素的和并返回
        String name = list.get(0).getClass().getName();
        System.out.println(name);
        Number sum = 0;
        for (Number number : list) {
            sum = sum.doubleValue() + number.doubleValue();
        }
        System.out.println(sum);
    }

    public static void add(ArrayList<? super Number> list) {
        // 向list中添加元素
        list.add(1);
        list.add(2.2);
        list.add(3.3);
    }
}

class Person {

    public Person() {
    }

    public Person(String name, int age) {
    }
}

class Student extends Person {

    public Student() {
    }

    public Student(String name, int age) {
        super(name, age);
    }
}

class Worker extends Person {

    public Worker() {
    }


    public Worker(String name, int age) {
        super(name, age);
    }
}