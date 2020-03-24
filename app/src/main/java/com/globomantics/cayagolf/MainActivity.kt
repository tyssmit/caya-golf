package com.globomantics.cayagolf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.user_registration.*

class MainActivity : AppCompatActivity() {
    private lateinit var name: EditText
    private lateinit var user: EditText
    private lateinit var email: EditText
    private lateinit var email2: EditText
    private lateinit var final_email: EditText
    private lateinit var password2: EditText
    private lateinit var final_password: EditText
    private lateinit var password: EditText
    private lateinit var login: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        email = findViewById(R.id.emailReg)
        email2= findViewById(R.id.confEmailReg)
        if(email.equals(email2)){
            final_email=findViewById(R.id.confEmailReg)
        }
        else{
            Toast.makeText(this, "emails do not match",Toast.LENGTH_SHORT).show()
        }
        password=findViewById(R.id.passwordReg)
        password2= findViewById(R.id.confPasswordReg)
        if(password.equals(password2)){
            final_password=findViewById(R.id.confEmailReg)
        }
        else{
            Toast.makeText(this, "passwords do not match",Toast.LENGTH_SHORT).show()
        }

    }
}
