package com.michalrys.my_notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // get message from intent
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        //create text view
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);

        //set text view as the activity layout
        setContentView(textView);
    }
}