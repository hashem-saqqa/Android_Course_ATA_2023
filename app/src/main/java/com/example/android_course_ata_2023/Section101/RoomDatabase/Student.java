package com.example.android_course_ata_2023.Section101.RoomDatabase;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "students_table" )
public class Student {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private double Gpa;

    public Student(String name, double Gpa) {
        this.name = name;
        this.Gpa = Gpa;
    }
    @Ignore
    public Student(int id ,String name, double Gpa) {
        this.name = name;
        this.Gpa = Gpa;
        this.id = id;
    }

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

    public double getGpa() {
        return Gpa;
    }

    public void setGpa(double gpa) {
        Gpa = gpa;
    }
}
