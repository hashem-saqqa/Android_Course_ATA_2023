package com.example.android_course_ata_2023.Section101.RoomDatabasePart2;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TeamDao {
    @Insert
    void insertTeam(Team team);
    @Update
    void updateTeam(Team team);
    @Delete
    void deleteTeam(Team team);
    @Query("SELECT * FROM Team")
    LiveData<List<Team>> getAllTeams();
    @Query("SELECT * FROM team WHERE id = :teamId")
    LiveData<Team> getTeamById(int teamId);



}
