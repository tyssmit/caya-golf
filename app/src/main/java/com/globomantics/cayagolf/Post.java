package com.globomantics.cayagolf;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;

import static com.globomantics.cayagolf.R.id;
import static com.globomantics.cayagolf.R.layout;

public class Post extends Scores {
Button add1, add2, add3, add4, add5, add6, add7, add8, add9;
Button minus1, minus2, minus3, minus4, minus5, minus6, minus7, minus8, minus9;
Number hole1, hole2, hole3, hole4, hole5, hole6, hole7, hole8, hole9;
    private Button Add1;
    private Button Add2;
    private Button Add3;
    private Button Add4;
    private Button Add5;
    private Button Add6;
    private Button Add7;
    private Button Add8;
    private Button Add9;
    private Button Minus1;
    private Button Minus2;
    private Button Minus3;
    private Button Minus4;
    private Button Minus5;
    private Button Minus6;
    private Button Minus7;
    private Button Minus8;
    private Button Minus9;

    private Number Hole1;
    private Number Hole2;
    private Number Hole3;
    private Number Hole4;
    private Number Hole5;
    private Number Hole6;
    private Number Hole7;
    private Number Hole8;
    private Number Hole9;



    @NonNull
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_scores);

    }


     public Post(){
        Add1 = findViewById(id.add1);
        Add2 = findViewById(id.add2);
        Add3 = findViewById(id.add3);
        Add4 = findViewById(id.add4);
        Add5 = findViewById(id.add5);
        Add6 = findViewById(id.add6);
        Add7 = findViewById(id.add7);
        Add8 = findViewById(id.add8);
        Add9 = findViewById(id.add9);
        Minus1 = findViewById(id.minus1);
         Minus2 = findViewById(id.minus2);
         Minus3 = findViewById(id.minus3);
         Minus4 = findViewById(id.minus4);
         Minus5 = findViewById(id.minus5);
         Minus6 = findViewById(id.minus6);
         Minus7 = findViewById(id.minus7);
         Minus8 = findViewById(id.minus8);
         Minus9 = findViewById(id.minus9);

         Add1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v){
                 Hole1 = +1;

             }
         });
         Add2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v){
                 Hole2 = +1;

             }
         });
         Add3.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v){
                 Hole3 = +1;

             }
         });
         Add4.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v){
                 Hole4 = +1;

             }
         });
         Add5.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v){
                 Hole5 = +1;

             }
         });
         Add6.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v){
                 Hole6 = +1;

             }
         });
         Add7.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v){
                 Hole7 = +1;

             }
         });
         Add8.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v){
                 Hole8 = +1;

             }
         });
         Add9.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v){
                 Hole9 = +1;

             }
         });


     }



}
