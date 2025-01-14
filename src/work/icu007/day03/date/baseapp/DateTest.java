package work.icu007.day03.date.baseapp;

import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        method1();
    }

    public static void method1() {
        Date date = new Date();
        System.out.println(date);

        long time = date.getTime();
        System.out.println(time);
    }
}
