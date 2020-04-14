package com.globomantics.cayagolf

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.user_registration.*

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth


override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    auth = FirebaseAuth.getInstance()

    CreateSubmit.setOnClickListener{
        startActivity(Intent(this, SignUpActivity::class.java))
        finish()
    }
    LogInSubmit.setOnClickListener{
        doLogin()
    }
}
    private fun doLogin(){
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
        auth.signInWithEmailAndPassword(emailReg.text.toString(), passwordReg.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    Toast.makeText(baseContext, "Login failed.",
                        Toast.LENGTH_SHORT).show()
                    updateUI(null)
                    // ...
                }

                // ...
            }
    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }

    fun updateUI (currentUser: FirebaseUser?){

    }

}
