package com.globomantics.cayagolf

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

import kotlinx.android.synthetic.main.user_registration.*

class SignUpActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_registration)
        auth = FirebaseAuth.getInstance()
       register.setOnClickListener{
           signUpUser()
       }
    }
    fun signUpUser(){

        if(passwordReg.text.toString().isEmpty()){
            passwordReg.error = "please enter a password"
            passwordReg.requestFocus()
        }

        if(emailReg.text.toString().isEmpty()){
            emailReg.error = "please enter email"
            emailReg.requestFocus()
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(emailReg.text.toString()).matches()){
            emailReg.error = "Please enter a valid email"
            emailReg.requestFocus()
        }
        auth.createUserWithEmailAndPassword(emailReg.text.toString(), passwordReg.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    if(task.isSuccessful){
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    }
                } else {
                    Toast.makeText(baseContext, "Sign Up failed. Try again after some time",
                        Toast.LENGTH_SHORT).show()
                }

                // ...
            }
    }
}