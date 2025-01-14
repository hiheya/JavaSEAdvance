package work.icu007.day06.work;

import java.util.LinkedHashMap;
import java.util.Objects;

public class Test08 {
    public static void main(String[] args) {
        LinkedHashMap<StudentTest08, String> studentHashMap = new LinkedHashMap<>();
        studentHashMap.put(new StudentTest08("20250101", "张三", 80), "上海");
        studentHashMap.put(new StudentTest08("20250102", "李四", 70), "北京");
        studentHashMap.put(new StudentTest08("20250101", "王五", 80), "上海");
        studentHashMap.put(new StudentTest08("20250103", "赵六", 90), "深圳");

        System.out.println(studentHashMap);
    }
}

class StudentTest08 {
    String id;
    String name;
    float score;

    public StudentTest08(String id, String name, float score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentTest08 that = (StudentTest08) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "StudentTest08{" +
                "学号='" + id + '\'' +
                ", 名字='" + name + '\'' +
                ", 分数=" + score +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
