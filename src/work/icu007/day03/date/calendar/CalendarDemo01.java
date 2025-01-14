package work.icu007.day03.date.calendar;

import java.util.Calendar;

// 写代码实现 获取2022年10月1日是星期几
public class CalendarDemo01 {
    public static void main(String[] args) {
        int year = 2024;
        int month = 4;
        int day = 21;
        int weekDay = getWeekDay(year, month, day);
        System.out.println(weekDay);
    }

    public static int getWeekDay(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
        weekDay = (weekDay - 2 + 7) % 7 + 1;
        return weekDay;

    }
}

