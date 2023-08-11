package com.example.android_course_ata_2023.Section101.RoomDatabasePart2;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Player.class, Team.class}, version = 2)
public abstract class PlayersDatabase extends RoomDatabase {

    public abstract PlayerDao playerDao();
    public abstract TeamDao teamDao();

    private static volatile PlayersDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static PlayersDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (PlayersDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    PlayersDatabase.class, "players_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
