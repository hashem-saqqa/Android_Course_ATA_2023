package com.example.android_course_ata_2023.Section101.Revision1;

public class Student {
    private String studentName;
    private int studentId;
    private double studentGPA;

    public Student(String studentName, int studentId, double studentGPA) {
        this.studentName = studentName;
        this.studentId = studentId;
        this.studentGPA = studentGPA;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public double getStudentGPA() {
        return studentGPA;
    }

    public void setStudentGPA(double studentGPA) {
        this.studentGPA = studentGPA;
    }
}
