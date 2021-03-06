package com.michalrys.my_notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.michalrys.my_notes.db.DataBaseManager;
import com.michalrys.my_notes.db.Note;
import com.michalrys.my_notes.db.RoomDao;
import com.michalrys.my_notes.db.RoomNote;
import com.michalrys.my_notes.db.RoomNoteDatabase;

import java.util.List;

public class MyNotesMainActivity extends AppCompatActivity {
    private Long clickedNoteId;
    public final static String ID_OF_CLICKED_NOTE = "com.michalrys.my_notes.ID_OF_CLICKED_NOTE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_notes_main);
        ListView myNotes = findViewById(R.id.mynotes_list);

//        // ROOM
//        RoomNoteDatabase db = RoomNoteDatabase.getDatabase(this);
//        RoomDao roomDao = db.roomDao();
//
//        LiveData<List<RoomNote>> notes = roomDao.getAll();
//        notes.observe(this, words -> {
//            for (RoomNote roomNote : words) {
//                Log.d("DB", roomNote.toString());
//            }
//            ArrayAdapter<RoomNote> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, words);
//            ListView mynotes = findViewById(R.id.mynotes_list);
//            mynotes.setAdapter(adapter);
//        });

        // dbManager

        DataBaseManager dbManager = new DataBaseManager(this);
        List<Note> allNotes = dbManager.getAll();
        ListView notesList = findViewById(R.id.mynotes_list);

        Intent intent = new Intent(this, MyNotesDisplayUpdateNoteActivity.class);
        notesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Note clickedNote = (Note) parent.getItemAtPosition(position);
                clickedNoteId = clickedNote.getId();
                intent.putExtra(ID_OF_CLICKED_NOTE, String.valueOf(clickedNoteId));
                startActivity(intent);
            }
        });

        ArrayAdapter<Note> noteArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, allNotes);
        notesList.setAdapter(noteArrayAdapter);
    }

    public void createNewNote(View view) {
        Intent intent = new Intent(this, MyNotesDisplayNewNoteActivity.class);
        startActivity(intent);
    }

    public void createNewNote(View view, Long id) {
        Intent intent = new Intent(this, MyNotesDisplayNewNoteActivity.class);
        startActivity(intent);
    }
}