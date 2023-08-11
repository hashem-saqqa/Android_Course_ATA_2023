package com.example.android_course_ata_2023.Section101.RoomDatabasePart2;

import android.graphics.Bitmap;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.Date;

@Entity(foreignKeys = @ForeignKey(entity = Team.class,
        parentColumns = {"id"}, childColumns = {"teamId"}))
@TypeConverters({Converters.class})
public class Player {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private int shirtNo;
    private Date DateOfBirth;
    private int teamId;
    private Bitmap photo;

    public Player(String name, int shirtNo, Date DateOfBirth, int teamId, Bitmap photo) {
        this.name = name;
        this.shirtNo = shirtNo;
        this.DateOfBirth = DateOfBirth;
        this.teamId = teamId;
        this.photo = photo;
    }

    @Ignore
    public Player(int id, String name, int shirtNo, Date dateOfBirth,  int teamId, Bitmap photo) {
        this.id = id;
        this.name = name;
        this.shirtNo = shirtNo;
        DateOfBirth = dateOfBirth;
        this.teamId = teamId;
        this.photo = photo;
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

    public int getShirtNo() {
        return shirtNo;
    }

    public void setShirtNo(int shirtNo) {
        this.shirtNo = shirtNo;
    }

    public Date getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }


    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public Bitmap getPhoto() {
        return photo;
    }

    public void setPhoto(Bitmap photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shirtNo=" + shirtNo +
                ", DateOfBirth=" + DateOfBirth +
                ", teamId=" + teamId +
                ", photo=" + photo +
                '}';
    }
}
