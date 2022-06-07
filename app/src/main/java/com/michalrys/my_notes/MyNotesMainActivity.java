package com.michalrys.my_notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.michalrys.my_notes.db.DataBaseManager;
import com.michalrys.my_notes.db.Note;

import java.time.LocalDateTime;

public class MyNotesMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_notes_main);
        ListView myNotes = findViewById(R.id.mynotes_list);

        //TODO: create some dummy input for db
        //TODO: load notes and create list with delete button and edit button
        //TODO: when edit button is pressed --> open activity like for sending message and place
        //TODO:     there title, content, save button and cancel button.

        DataBaseManager dbManager = new DataBaseManager(this);
        dbManager.runQuery("DROP TABLE NOTES;");
        dbManager.runQuery("CREATE TABLE NOTES(" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "TITLE CHAR(40)," +
                "CONTENT CHAR(100)," +
                "CREATED CHAR(50));" +
                "");
        dbManager.addNote(new Note("Lista zakupów", "1. Masło\n2. Chleb\n3. Benzyna", "2022-06-05 20:19"));
        dbManager.addNote(new Note("Odsłuchać", "1. Myslovitz\n2. Pogodno\n3. Melt-Banana", "2022-06-06 06:11"));
        dbManager.addNote(new Note("Kochany pamiętniku", "Na górze róże na dole fiołki a pada deszcz.", "2022-06-07 20:17"));
        dbManager.addNote(new Note("Kochany pamiętniku", "Na górze róże na dole fiołki a pada deszcz.", "2022-06-07 20:17"));

        for (Note note : dbManager.getAll()) {
            Log.d("DB", String.format("%d %s %s %s", note.getId(), note.getCreated(), note.getTitle(), note.getContent()));
        }

        // delete
        Log.d("DB", "Note with id 4 was deleted.");
        dbManager.deleteNote(4);
        for (Note note : dbManager.getAll()) {
            Log.d("DB", String.format("%d %s %s %s", note.getId(), note.getCreated(), note.getTitle(), note.getContent()));
        }

        // update
        Note noteToUpdate = new Note("Lista zakupów ZROBIONA", "1. Masło\n2. Chleb\n3. Benzyna", "2022-06-05 20:19");
        noteToUpdate.setId(1L);
        dbManager.updateNote(noteToUpdate);
        Note noteUpdated = dbManager.get(1);
        Log.d("DB", "Updated noted 1: " + noteUpdated);

        // ends basic operations -----------

    }

    public void createNewNote(View view) {
        Intent intent = new Intent(this, MyNotesDisplayNewNoteActivity.class);
        startActivity(intent);
    }
}