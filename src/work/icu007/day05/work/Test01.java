package work.icu007.day05.work;

import java.util.ArrayList;

public class Test01 {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<Person> list2 = new ArrayList<>();
        ArrayList<Student> list3 = new ArrayList<>();
        ArrayList<JavaStudent> list4 = new ArrayList<>();
        ArrayList<UIStudent> list5 = new ArrayList<>();
        ArrayList<Teacher> list6 = new ArrayList<>();
        ArrayList<JavaTeacher> list7 = new ArrayList<>();
        ArrayList<UITeacher> list8 = new ArrayList<>();

        // print1 均可调用
        print1(list1);
        print1(list2);
        print1(list3);
        print1(list4);
        print1(list5);
        print1(list6);
        print1(list7);
        print1(list8);

        // print2 限制了仅限Person子类的ArrayList可调用， list1为String类型的ArrayList。故不可调用
        //print2(list1);
        print2(list2);
        print2(list3);
        print2(list4);
        print2(list5);
        print2(list6);
        print2(list7);
        print2(list8);

        // print3 限制了仅限Student子类的ArrayList可调用
        //print3(list1);
        //print3(list2);
        print3(list3);
        print3(list4);
        print3(list5);
        //print3(list6);
        //print3(list7);
        //print3(list8);

        // print4限制了仅限JavaStudent 的父类ArrayList可调用
        //print4(list1);
        print4(list2);
        print4(list3);
        print4(list4);
        //print4(list5);
        //print4(list6);
        //print4(list7);
        //print4(list8);

    }

    public static void print1(ArrayList<?> List) {
    }

    public static void print2(ArrayList<? extends Person> list){
    }

    public static void print3(ArrayList<? extends Student> list){}

    public static void print4(ArrayList<? super JavaStudent> list) {}
}

class Person{}

class Student extends Person{}
class JavaStudent extends Student{}
class UIStudent extends Student{}

class Teacher extends Person{}
class JavaTeacher extends Teacher{}
class UITeacher extends Teacher{}
