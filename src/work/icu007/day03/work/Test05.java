package work.icu007.day03.work;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
获取当前系统的时间，以“xxxx年xx月xx日 xx时xx分xx秒”的格式打印出来。
 */
public class Test05 {
    public static void main(String[] args) {
        // 获取当前系统的时间
        Date date = new Date();
        // 以“xxxx年xx月xx日 xx时xx分xx秒”的格式打印出来
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        String format = simpleDateFormat.format(date);
        System.out.println(format);
    }
}
