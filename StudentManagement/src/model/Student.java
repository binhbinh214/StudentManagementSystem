package model;

public class Student {

    private int id;
    private String name;
    private int semester;
    private String courseName;

    public Student(int id, String name, int semester, String courseName) {
        this.id = id;
        this.name = name;
        this.semester = semester;
        this.courseName = courseName;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSemester() {
        return semester;
    }

    public String getCourseName() {
        return courseName;
    }

    @Override
    public String toString() {
        return "Student name: " + name + ", Semester: " + semester + ", Course Name: " + courseName;
    }
}
