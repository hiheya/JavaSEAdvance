package work.icu007.day06.work;

import java.util.*;

public class Test10 {
    public static void main(String[] args) {
        // 创建学生对象
        StudentTest08 student1 = new StudentTest08("20250101", "张三", 70);
        StudentTest08 student2 = new StudentTest08("20250102", "李四", 80);
        StudentTest08 student3 = new StudentTest08("20250103", "王五", 90);
        StudentTest08 student4 = new StudentTest08("20250104", "赵六", 100);

        // 创建班级Map
        Map<Integer, StudentTest08> class01HashMap = new HashMap<>();
        Map<Integer, StudentTest08> class02HashMap = new HashMap<>();
        Map<Integer, StudentTest08> class03HashMap = new HashMap<>();

        // 向班级Map中添加学生
        addStudent(class01HashMap, student1, student2, student3, student4);
        addStudent(class02HashMap, student1, student2, student3, student4);
        addStudent(class03HashMap, student1, student2, student3, student4);

        // 将班级Map放入一个新的Map，键为班级名
        Map<String, Map<Integer, StudentTest08>> gradeMap = new HashMap<>();
        gradeMap.put("班级1", class01HashMap);
        gradeMap.put("班级2", class02HashMap);
        gradeMap.put("班级3", class03HashMap);

        // 遍历所有班级及其学生信息
        for (Map.Entry<String, Map<Integer, StudentTest08>> entry : gradeMap.entrySet()) {
            String className = entry.getKey();  // 获取班级名
            Map<Integer, StudentTest08> studentsMap = entry.getValue();  // 获取班级中的学生信息

            System.out.println(className + "：");
            for (Map.Entry<Integer, StudentTest08> studentEntry : studentsMap.entrySet()) {
                Integer id = studentEntry.getKey();  // 学生ID
                StudentTest08 student = studentEntry.getValue();  // 学生信息
                System.out.println(id + "---" + student);
            }
            System.out.println("----------------------------------");
        }
    }

    // 修改为接受具体的学生对象
    private static void addStudent(Map<Integer, StudentTest08> classHashMap,
                                   StudentTest08... students) {
        for (StudentTest08 student : students) {
            classHashMap.put(Integer.parseInt(student.getId()), student);
        }
    }
}