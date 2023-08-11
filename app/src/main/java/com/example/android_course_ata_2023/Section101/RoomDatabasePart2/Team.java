package com.example.android_course_ata_2023.Section101.RoomDatabasePart2;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Team {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private int noOfCups;

    @Ignore
    public Team(int id, String name, int noOfCups) {
        this.id = id;
        this.name = name;
        this.noOfCups = noOfCups;
    }

    public Team(String name, int noOfCups) {
        this.name = name;
        this.noOfCups = noOfCups;
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

    public int getNoOfCups() {
        return noOfCups;
    }

    public void setNoOfCups(int noOfCups) {
        this.noOfCups = noOfCups;
    }
}
