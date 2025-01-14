package work.icu007.day05.work;

import java.util.ArrayList;

public class Test05 {
    public static void main(String[] args) {
        ArrayList<StudentTest05> studentArrayList = new ArrayList<>();
        studentArrayList.add(new StudentTest05("zs", 23, "male"));
        studentArrayList.add(new StudentTest05("ls", 24, "male"));
        studentArrayList.add(new StudentTest05("w5", 25, "female"));

        int index = 0;
        int maxAge = 0;
        for (int i = 0; i < studentArrayList.size(); i++) {
            if (studentArrayList.get(i).getAge() > maxAge) index = i;
        }
        System.out.println(studentArrayList);
        studentArrayList.get(index).setName("xzpq");
        System.out.println(studentArrayList);
    }
}

class StudentTest05 {
    private String name;
    private int age;
    private String gender;

    public StudentTest05() {
    }

    public StudentTest05(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "StudentTest05{" +
                "姓名='" + name + '\'' +
                ", 年龄=" + age +
                ", 性别='" + gender + '\'' +
                '}';
    }
}
