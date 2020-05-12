package com.bossdga.githubclient.source.persistence;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.bossdga.githubclient.model.GitRepository;

/**
 * Class that represents a Room database
 */
@Database(entities = {GitRepository.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "git_db";
    private static AppDatabase INSTANCE;

    public abstract GitRepoDao gitRepoDao();

    public static AppDatabase getDatabase(final Context context) {
        synchronized (AppDatabase.class) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class, DATABASE_NAME)
                        .build();

            }
        }
        return INSTANCE;
    }

}