package com.example.android_course_ata_2023.Section101.RoomDatabasePart2;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MyViewModel extends AndroidViewModel {
    MyRepository repository;

    public MyViewModel(@NonNull Application application) {
        super(application);
        repository = new MyRepository(application);
    }

    void insertTeam(Team team) {
        repository.insertTeam(team);
    }

    void updateTeam(Team team) {
        repository.updateTeam(team);
    }

    void deleteTeam(Team team) {
        repository.deleteTeam(team);
    }

    LiveData<List<Team>> getAllTeams() {
        return repository.getAllTeams();
    }

    LiveData<Team> getTeamById(int teamId) {
        return repository.getTeamById(teamId);
    }

    void insertPlayer(Player player) {
        repository.insertPlayer(player);
    }

    void updatePlayer(Player player) {
        repository.updatePlayer(player);
    }

    void deletePlayer(Player player) {
        repository.deletePlayer(player);
    }

    LiveData<List<Player>> getAllPlayers() {
        return repository.getAllPlayers();
    }


    LiveData<List<Player>> getAllPlayersByTeamId(int teamId) {
        return repository.getAllPlayersByTeamId(teamId);
    }
}
