package com.michalrys.my_notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.michalrys.my_notes.db.DataBaseManager;
import com.michalrys.my_notes.db.Note;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void myNotesApp(View view) {
        Intent intent = new Intent(this, MyNotesMainActivity.class);
        startActivity(intent);
    }

    public void counterApp(View view) {
        Intent intent = new Intent(this, DisplayCounter.class);
        startActivity(intent);
    }

    public void sendingMessageApp(View view) {
        Intent intent = new Intent(this, DisplaySendingMessageActivity.class);
        startActivity(intent);
    }
}