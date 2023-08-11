package com.example.android_course_ata_2023.Section101.RoomDatabasePart2;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PlayerDao {
    @Insert
    void insertPlayer(Player player);
    @Update
    void updatePlayer(Player player);
    @Delete
    void deletePlayer(Player player);
    @Query("SELECT * FROM Player")
    LiveData<List<Player>> getAllPlayers();

    @Query("SELECT * FROM Player WHERE teamId = :teamId")
    LiveData<List<Player>> getAllPlayersByTeamId(int teamId);
}
