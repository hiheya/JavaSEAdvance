package work.icu007.day03.work;

import java.util.Calendar;
import java.util.Scanner;

/*
请编写程序，使用Calendar类获取日历对象，并分别获取年、月、日、小时、分、秒，星期信息并将它们打印到控制台。
 */
public class Test06 {
    public static void main(String[] args) {
        // 获取日历对象
         Calendar calendar = Calendar.getInstance();
         System.out.println(calendar);
        // 获取年、月、日、小时、分、秒
         int year = calendar.get(Calendar.YEAR);
         int month = calendar.get(Calendar.MONTH) + 1;
         int day = calendar.get(Calendar.DAY_OF_MONTH);
         int hour = calendar.get(Calendar.HOUR_OF_DAY);
         int minute = calendar.get(Calendar.MINUTE);
         int second = calendar.get(Calendar.SECOND);
         System.out.println(year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second);
        // 获取星期信息
         int weekDay = (calendar.get(Calendar.DAY_OF_WEEK) - 2 + 7) % 7 + 1;
         System.out.println(getWeek(weekDay));

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入年份：");
        int year1 = scanner.nextInt();

        int monthLastDay = getMonthLastDay(year1);
        System.out.println(year1 + "年2月份最后一天是" + monthLastDay + "号");
    }

    public static String getWeek(int field){
        String[] str = { "" , "MONDAY" , "TUESDAY" , "WEDNESDAY" , "THURSDAY" , "FRIDAY" , "SATURDAY", "SUNDAY" };
        return str[field];
    }

    // 键盘录入一个年份，计算所录入年份的2月份最后一天是几号
    public static int getMonthLastDay(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, 2, 1);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }
}
