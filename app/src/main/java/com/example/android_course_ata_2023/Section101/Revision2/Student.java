package com.example.android_course_ata_2023.Section101.Revision2;

import android.graphics.Bitmap;

public class Student {
    private int id;
    private String name;
    private double GPA;

    public Student(int id, String name, double GPA, Bitmap image) {
        this.id = id;
        this.name = name;
        this.GPA = GPA;
        this.image = image;
    }
    public Student(String name, double GPA, Bitmap image) {
        this.name = name;
        this.GPA = GPA;
        this.image = image;
    }
    public Student(int id, String name, double GPA) {
        this.id = id;
        this.name = name;
        this.GPA = GPA;
    }


    private Bitmap image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
