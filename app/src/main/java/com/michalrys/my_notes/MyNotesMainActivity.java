package com.michalrys.my_notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MyNotesMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_notes_main);

        //TODO: create some dummy input for db
        //TODO: load notes and create list with delete button and edit button
        //TODO: when edit button is pressed --> open activity like for sending message and place
        //TODO:     there title, content, save button and cancel button.

    }

    public void createNewNote(View view) {
        Intent intent = new Intent(this, MyNotesDisplayNewNoteActivity.class);
        startActivity(intent);
    }
}