package com.michalrys.my_notes;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.michalrys.my_notes.db.DataBaseManager;
import com.michalrys.my_notes.db.Note;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyNotesDisplayNewNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_notes_display_new_note);
    }

    public void cancelNewNoteAndGoBack(View view) {
        Intent intent = new Intent(this, MyNotesMainActivity.class);
        startActivity(intent);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void saveNote(View view) {
        TextView titleView = findViewById(R.id.mynotes_new_message_title);
        TextView contentView = findViewById(R.id.mynotes_new_message_content);
        String dateOfCreation = LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm"));
        String title = String.valueOf(titleView.getText()).length() == 0 ? "untitled" : String.valueOf(titleView.getText());

        Note note = new Note(title, String.valueOf(contentView.getText()), dateOfCreation);

        DataBaseManager dbManager = new DataBaseManager(this);
        dbManager.addNote(note);

        Intent intent = new Intent(this, MyNotesMainActivity.class);
        startActivity(intent);
    }
}