package com.globomantics.cayagolf;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registration extends AppCompatActivity {
    EditText firstName, userName, passwordReg, confPassword,emailReg,confEmail;
    Button registerButton;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       // if(fAuth.getCurrentUser() != null){
         //   startActivity(new Intent(getApplicationContext(),MainActivity2.class));
          //  finish();
        //}
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        firstName = findViewById(R.id.firstName);
        passwordReg = findViewById(R.id.passwordReg);
        confPassword = findViewById(R.id.confPassword);
        emailReg = findViewById(R.id.emailReg);
        confEmail = findViewById(R.id.confPassword);
        registerButton = findViewById(R.id.registerButton);

        fAuth = FirebaseAuth.getInstance();
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String email = emailReg.getText().toString().trim();
                String password = passwordReg.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    emailReg.setError("Please enter an email");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    passwordReg.setError("Please enter an password");
                    return;
                }
                if(password.length() < 6){
                    passwordReg.setError("please enter a password longer than 6 characters");
                    return;
                }
                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Registration.this, "User Created", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity2.class));
                        }
                        else{
                            Toast.makeText(Registration.this, "Error! user not created"+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
    }


}
