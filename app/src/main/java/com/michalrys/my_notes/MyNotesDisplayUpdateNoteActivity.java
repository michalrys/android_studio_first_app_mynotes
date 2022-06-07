package com.michalrys.my_notes;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.michalrys.my_notes.db.DataBaseManager;
import com.michalrys.my_notes.db.Note;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyNotesDisplayUpdateNoteActivity extends AppCompatActivity {
    private Long noteId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_notes_display_update_note);

        // get message from intent
        Intent intent = getIntent();
        String idOfClickedNote = intent.getStringExtra(MyNotesMainActivity.ID_OF_CLICKED_NOTE);
        DataBaseManager dbManager = new DataBaseManager(this);
        noteId = Long.parseLong(idOfClickedNote);

        Note note = dbManager.get(noteId.intValue());

        TextView titleView = findViewById(R.id.mynotes_update_message_title);
        TextView contentView = findViewById(R.id.mynotes_update_message_content);

        titleView.setText(note.getTitle());
        contentView.setText(note.getContent());
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void saveNote(View view) {
        TextView titleView = findViewById(R.id.mynotes_update_message_title);
        TextView contentView = findViewById(R.id.mynotes_update_message_content);
        String dateOfCreation = LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm"));
        String title = String.valueOf(titleView.getText()).length() == 0 ? "untitled" : String.valueOf(titleView.getText());

        Note note = new Note(title, String.valueOf(contentView.getText()), dateOfCreation);
        note.setId(noteId);

        DataBaseManager dbManager = new DataBaseManager(this);
        dbManager.updateNote(note);

        Intent intent = new Intent(this, MyNotesMainActivity.class);
        startActivity(intent);
    }

    public void cancelNewNoteAndGoBack(View view) {
        Intent intent = new Intent(this, MyNotesMainActivity.class);
        startActivity(intent);
    }
}