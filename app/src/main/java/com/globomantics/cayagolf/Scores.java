package com.globomantics.cayagolf;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class Scores extends AppCompatActivity {
    Spinner CourseSelection;
    RadioButton radioBlack, radioBlue, radioWhite, radioOrange, radio18, radioFront9, radioBack9;
    Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_scores);

        CourseSelection = findViewById(R.id.CourseSelection);
        radioBlack = findViewById(R.id.radioBlack);
        radioBlue = findViewById(R.id.radioBlue);
        radioWhite = findViewById(R.id.radioWhite);
        radioOrange = findViewById(R.id.radioOrange);
        radio18 = findViewById(R.id.radio18);
        radioFront9 = findViewById(R.id.radioFront9);
        radioBack9 = findViewById(R.id.radioBack9);

        buttonNext.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View v){
            String course = CourseSelection.getSelectedItem().toString().trim();
            String holes = radio18.toString().trim();
            String teeBox = radioBlack.toString().trim();

            if (TextUtils.isEmpty(course)) {
                CourseSelection.setPrompt("Please Select a Course");
                return;
            }

            if (TextUtils.isEmpty(holes)) {
                radioBlack.setError("Please select amount of holes played");
            }


        };

        });
    }
}
