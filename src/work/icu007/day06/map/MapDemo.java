package work.icu007.day06.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo {
    public static void main(String[] args) {
        Map<Student, String> studentMap = new HashMap<>();
        studentMap.put(new Student("zs", 15),"shanghai");
        studentMap.put(new Student("ls", 14),"beijing");
        studentMap.put(new Student("zs", 13),"shanghai");

        Set<Student> students = studentMap.keySet();

        for (Student student : students) {
            System.out.println(student);
        }

    }
}


