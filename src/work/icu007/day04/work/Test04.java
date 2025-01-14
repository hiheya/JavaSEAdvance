package work.icu007.day04.work;

/**
 * 键盘录入一段字符串，字符串包含一个学生的姓名，年龄，身高信息。这三个信息以中划线分隔，例如：
 *
 * ```java
 * 张三-18-180
 *
 * 1. 录入字符串
 * 2. 按照 - 切割字符串    {"张三","18","180"}
 * 3. 把切割后的字符串，作为数据值，填充到学生对象中
 * ```
 *
 * 定义学生类包含属性姓名，年龄，身高，将上述字符串转换为学生对象。打印对象，将对象的属性信息显示出来。
 *
 * **答案：**
 *
 * 思路：
 *
 * ```java
 * 先去创建学生类
 * 创建测试类，在测试类里面键盘输入字符串，将字符串的信息切割得到对应信息转换为学生对象的属性值
 * ```
 *
 * 步骤：
 *
 * 1. 先把学生类定义出来
 * 2. 定义测试类，写出main方法
 * 3. main方法中创建学生对象，创建键盘录入的对象
 * 4. 键盘录入字符串
 * 5. 切割解析字符串，并设置到对象
 * 6. 打印对象信息
 */
public class Test04 {
    public static void main(String[] args) {
        Student student = new Student();
        String str = "张三-18-180";
        String[] split = str.split("-");
        student.setName(split[0]);
        student.setAge(Integer.parseInt(split[1]));
        student.setHeight(Integer.parseInt(split[2]));
        System.out.println(student);
    }

    static class Student {
        private String name;
        private int age;
        private int height;

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

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", height=" + height +
                    '}';
        }
    }
}
