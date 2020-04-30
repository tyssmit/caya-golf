package com.globomantics.cayagolf;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Scores extends Activity {


    Spinner CourseSelection;
    RadioButton radioBlack, radioBlue, radioWhite, radioOrange, radio18, radioFront9, radioBack9;
    Button buttonNext;
    private Button btnScores;
    private DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_scores);}

        public Scores(){
        btnScores = findViewById(R.id.buttonNext);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("AndroidView");
        Spinner CourseSelection = findViewById(R.id.CourseSelection);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.planets_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        CourseSelection.setAdapter(adapter);
        CourseSelection = findViewById(R.id.CourseSelection);
        radioBlack = findViewById(R.id.radioBlack);
        radioBlue = findViewById(R.id.radioBlue);
        radioWhite = findViewById(R.id.radioWhite);
        radioOrange = findViewById(R.id.radioOrange);
        radio18 = findViewById(R.id.radio18);
        radioFront9 = findViewById(R.id.radioFront9);
        radioBack9 = findViewById(R.id.radioBack9);

        final Spinner finalCourseSelection = CourseSelection;
        buttonNext.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View v){
            String course = finalCourseSelection.getSelectedItem().toString().trim();
            String holes = radio18.toString().trim();
            String teeBox = radioBlack.toString().trim();

            if (TextUtils.isEmpty(course)) {
                finalCourseSelection.setPrompt("Please Select a Course");
                return;
            }

            if (TextUtils.isEmpty(holes)) {
                radioBlack.setError("Please select amount of holes played");
            }


        }

        });

        btnScores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToScores();
            }
        });
        }

    private void moveToScores() {
        Intent intent = new Intent(Scores.this, Post.class);
    }


}
