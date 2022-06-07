package com.michalrys.my_notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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
}