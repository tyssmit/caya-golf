package com.globomantics.cayagolf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    EditText emailReg,passwordReg;
    Button logInSubmit, createSubmit;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailReg = findViewById(R.id.emailLog);
        passwordReg = findViewById(R.id.passwordLog);
        fAuth = FirebaseAuth.getInstance();
        logInSubmit = findViewById(R.id.logInSubmit);
        createSubmit = findViewById(R.id.createSubmit);

        logInSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Login.this, "Logged in", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity2.class));
                        }else{
                            Toast.makeText(Login.this, "Error! Something went wrong"+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        });
        createSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Registration.class));
            }
        });
    }
}
