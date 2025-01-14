package work.icu007.anonymous.base.example;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author {xiheya}
 * @Date: 2024/04/08/ 22:41
 * @Description
 */
public class Register {
    public static void main(String[] args) {
        // 键盘录入
        Scanner sc = new Scanner(System.in);

        System.out.println("用户名");
        String userName = sc.nextLine();
        System.out.println("手机号码");
        String phoneNumber = sc.nextLine();
        String password;
        String confirmPassword;
        while (true) {
            System.out.println("登陆密码");
            password = sc.nextLine();
            System.out.println("确认密码");
            confirmPassword = sc.nextLine();

            if (password.equals(confirmPassword)) {
                break;
            } else {
                System.out.println("两次密码不一致 请重新输入");
            }
        }

        System.out.println("电子邮箱");
        String email = sc.nextLine();
        System.out.println("性别");
        String sex = sc.nextLine();
        System.out.println("出生日期");
        String birthday = sc.nextLine();

        // 使用匿名对象作为参数
        ArrayList<User> userArrayList = new ArrayList<>();
        userArrayList.add(new User(userName, phoneNumber, password, confirmPassword, email, sex, birthday));
        for (User user : userArrayList) {
            System.out.print(user.getUserName() + ", ");
            System.out.print(user.getPhoneNumber() + ", ");
            System.out.print(user.getPassword() + ", ");
            System.out.print(user.getConfirmPassword() + ", ");
            System.out.print(user.getEmail() + ", ");
            System.out.print(user.getSex()
                    + ", ");
            System.out.println(user.getBirthday());
        }
    }
}
