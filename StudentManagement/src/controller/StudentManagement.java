package controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Student;

public class StudentManagement {

    private List<Student> students = new ArrayList<>();

    public void createStudent(Student student) {
        students.add(student);
    }

    public List<Student> findAndSortStudentsByName(String query) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().contains(query)) {
                result.add(student);
            }
        }
        result.sort(Comparator.comparing(Student::getName));
        return result;
    }

    public void updateStudent(int id, Student updatedStudent) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.set(i, updatedStudent);
                break;
            }
        }
    }

    public void deleteStudent(int id) {
        students.removeIf(student -> student.getId() == id);
    }

    public List<String> generateReport() {
        Map<String, Map<String, Integer>> reportMap = new HashMap<>();
        for (Student student : students) {
            String name = student.getName();
            String course = student.getCourseName();
            reportMap.putIfAbsent(name, new HashMap<>());
            reportMap.get(name).put(course, reportMap.get(name).getOrDefault(course, 0) + 1);
        }

        List<String> report = new ArrayList<>();
        for (Map.Entry<String, Map<String, Integer>> entry : reportMap.entrySet()) {
            String studentName = entry.getKey();
            Map<String, Integer> courseCounts = entry.getValue();
            for (Map.Entry<String, Integer> courseEntry : courseCounts.entrySet()) {
                String courseName = courseEntry.getKey();
                int totalCourses = courseEntry.getValue();
                report.add(studentName + " | " + courseName + " | " + totalCourses);
            }
        }
        return report;
    }
}
