package com.example.android_course_ata_2023.Section101.RoomDatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Student.class}, version = 1, exportSchema = false)
public abstract class StudentsDatabase extends RoomDatabase {

    public abstract StudentDao studentDao();

    private static volatile StudentsDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static StudentsDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (StudentsDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    StudentsDatabase.class, "students_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
