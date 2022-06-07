package com.michalrys.my_notes.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface RoomDao {
    @Insert
    void insertAll(RoomNote... roomNotes);

    @Delete
    void delete(RoomNote roomNote);

    @Query("SELECT * FROM room_note")
    LiveData<List<RoomNote>> getAll();

    @Query("DELETE FROM room_note")
    void deleteAll();
}
