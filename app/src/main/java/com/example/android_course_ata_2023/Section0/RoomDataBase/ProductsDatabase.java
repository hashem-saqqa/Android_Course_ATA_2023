package com.example.android_course_ata_2023.Section0.RoomDataBase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Product.class}, version = 1, exportSchema = false)
public abstract class ProductsDatabase extends RoomDatabase {

    public abstract ProductDao productDao();

    private static volatile ProductsDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static ProductsDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ProductsDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    ProductsDatabase.class, "products_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
