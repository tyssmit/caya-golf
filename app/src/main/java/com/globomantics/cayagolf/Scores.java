package com.globomantics.cayagolf;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Scores extends AppCompatActivity {
    Spinner CourseSelection;
    RadioButton radioBlack, radioBlue, radioWhite, radioOrange, radio18, radioFront9, radioBack9;
    Button buttonNext;
    private DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_scores);
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
    }
    private void setAdapter(ArrayAdapter<CharSequence> adapter) {
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.spinner, menu);
        return true;
    }
}
