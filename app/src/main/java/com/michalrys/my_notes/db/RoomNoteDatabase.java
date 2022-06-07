package com.michalrys.my_notes.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {RoomNote.class}, version = 1)
public abstract class RoomNoteDatabase extends RoomDatabase {
    public abstract RoomDao roomDao();

    private static volatile RoomNoteDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static RoomNoteDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (RoomNoteDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    RoomNoteDatabase.class, "notes")
                            .allowMainThreadQueries().build();
                }
            }
        }
        return INSTANCE;
    }
}