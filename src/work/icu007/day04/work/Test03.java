package work.icu007.day04.work;

import java.util.Scanner;

/**
 * 请定义学员类，有以下成员属性：
 *
 *        姓名：String类型
 *        年龄：int
 *        身高：double
 *        婚否：boolean
 *        性别：char
 *
 * 请从控制 台接收以下数据：
 *        姓名：王哈哈
 *        年龄：24
 *        身高：1.82
 *        婚否：false
 *        性别：男
 * 以上数据要求全部使用String类型接收
 * 请创建“学员对象”，并将所有数据转换后，存储到这个对象中，最后打印此对象的所有属性。
 */
public class Test03 {
    public static void main(String[] args) {
        Student student = new Student();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入姓名：");
        String name = scanner.next();
        System.out.println("请输入年龄：");
        String age = scanner.next();
        System.out.println("请输入身高：");
        String height = scanner.next();
        System.out.println("请输入婚否：");
        String isMarried = scanner.next();
        System.out.println("请输入性别：");
        String sex = scanner.next();

        student.setName(name);
        student.setAge(Integer.parseInt(age));
        student.setHeight(Double.parseDouble(height));
        student.setMarried(Boolean.parseBoolean(isMarried));
        student.setSex(sex.charAt(0));

        System.out.println(student);
    }

    static class Student {
        private String name;
        private int age;
        private double height;
        private boolean isMarried;
        private char sex;

        public Student(String name, int age, double height, boolean isMarried, char sex) {
            this.name = name;
            this.age = age;
            this.height = height;
            this.isMarried = isMarried;
            this.sex = sex;
        }

        public Student() {

        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", height=" + height +
                    ", isMarried=" + isMarried +
                    ", sex=" + sex +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public double getHeight() {
            return height;
        }

        public void setHeight(double height) {
            this.height = height;
        }

        public boolean isMarried() {
            return isMarried;
        }

        public void setMarried(boolean married) {
            isMarried = married;
        }

        public char getSex() {
            return sex;
        }

        public void setSex(char sex) {
            this.sex = sex;
        }
    }
}
