package work.icu007.day05.work;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Test07 {
    public static void main(String[] args) {
        Set<StudentTest07> studentTest07Set = new HashSet<>();

        studentTest07Set.add(new StudentTest07("zs","male",20));
        studentTest07Set.add(new StudentTest07("ls","female",21));
        studentTest07Set.add(new StudentTest07("zs","female",21));
        studentTest07Set.add(new StudentTest07("zs","male",20));
        studentTest07Set.add(new StudentTest07("zs","male",21));

        for (StudentTest07 studentTest07 : studentTest07Set) {
            System.out.println(studentTest07);
        }
    }
}

class StudentTest07 {
    String name;
    String gender;
    int age;

    public StudentTest07(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentTest07 that = (StudentTest07) o;
        return age == that.age && Objects.equals(name, that.name) && Objects.equals(gender, that.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender, age);
    }

    @Override
    public String toString() {
        return "StudentTest07{" +
                "姓名='" + name + '\'' +
                ", 性别='" + gender + '\'' +
                ", 年龄=" + age +
                '}';
    }
}
