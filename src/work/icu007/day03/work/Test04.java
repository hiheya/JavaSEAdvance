package work.icu007.day03.work;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
## 题目5

请编写程序，从控制台接收一个“生日”，格式：yyyy-MM-dd，程序要能够计算并打印他来到世界xx天。

**注意：“生日”必须早于“当前日期”，否则提示：生日必须早于当前日期！**
 */
public class Test04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入生日：");
        String birthdayStr = scanner.nextLine();
        System.out.println("请输入当前日期：");
        String currentDate = scanner.nextLine();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date birthdayDate;
        Date currentDateDate;
        try {
            birthdayDate = simpleDateFormat.parse(birthdayStr);
            currentDateDate = simpleDateFormat.parse(currentDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        if (birthdayDate.after(currentDateDate)) {
            System.out.println("生日必须早于当前日期！");
            return;
        }

        Birthday birthday = new Birthday(birthdayDate);

        birthday.printDays(currentDateDate);
    }
}

class Birthday {
    private Date birthday;

    public Birthday(Date birthday) {
        this.birthday = birthday;
    }

    public void printDays(Date currentDateDate) {
        long time = currentDateDate.getTime() - birthday.getTime();
        System.out.println("来到世界" + time / 1000 / 60 / 60 / 24 + "天");
    }
}

