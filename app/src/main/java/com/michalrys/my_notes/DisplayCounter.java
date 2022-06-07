package com.michalrys.my_notes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DisplayCounter extends AppCompatActivity {
    private int counterCurrentValue = 9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_counter);
        setCurrentValueIntoCounterTextField();
    }

    private void setCurrentValueIntoCounterTextField() {
        TextView counterTextView = findViewById(R.id.counterValue);
        counterTextView.setText(String.valueOf(counterCurrentValue));
    }

    public void increaseByOne(View view) {
        counterCurrentValue++;
        setCurrentValueIntoCounterTextField();
    }

    public void decreaseByOne(View view) {
        counterCurrentValue--;
        setCurrentValueIntoCounterTextField();
    }

    public void setZero(View view) {
        counterCurrentValue = 0;
        setCurrentValueIntoCounterTextField();
    }
}