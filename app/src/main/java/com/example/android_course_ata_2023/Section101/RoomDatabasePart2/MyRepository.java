package com.example.android_course_ata_2023.Section101.RoomDatabasePart2;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

public class MyRepository {
    private PlayerDao playerDao;
    private TeamDao teamDao;

    public MyRepository(Application application){
        PlayersDatabase db = PlayersDatabase.getDatabase(application);
        playerDao = db.playerDao();
        teamDao = db.teamDao();
    }


    void insertTeam(Team team){
        PlayersDatabase.databaseWriteExecutor.execute(() -> {
            teamDao.insertTeam(team);
        });
    }

    void updateTeam(Team team){
        PlayersDatabase.databaseWriteExecutor.execute(() -> {
            teamDao.updateTeam(team);
        });
    }

    void deleteTeam(Team team){
        PlayersDatabase.databaseWriteExecutor.execute(() -> {
            teamDao.deleteTeam(team);
        });
    }

    LiveData<List<Team>> getAllTeams(){
        return teamDao.getAllTeams();
    }

    LiveData<Team> getTeamById(int teamId){
        return teamDao.getTeamById(teamId);
    }

    void insertPlayer(Player player){
        PlayersDatabase.databaseWriteExecutor.execute(() -> {
            playerDao.insertPlayer(player);
        });
    }

    void updatePlayer(Player player){ PlayersDatabase.databaseWriteExecutor.execute(() -> {
        playerDao.updatePlayer(player);
    });}

    void deletePlayer(Player player){
        PlayersDatabase.databaseWriteExecutor.execute(() -> {
            playerDao.deletePlayer(player);
        });
    }

    LiveData<List<Player>> getAllPlayers(){
        return playerDao.getAllPlayers();
    }


    LiveData<List<Player>> getAllPlayersByTeamId(int teamId){
        return playerDao.getAllPlayersByTeamId(teamId);
    }
}
