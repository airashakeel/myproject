package com.example.khat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.*
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerbutton_registration.setOnClickListener {

         performRegister()


        }

        alreadyaccount_textview.setOnClickListener {
            Log.d("MainActivity","try to login ")
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }

        select_photo_button.setOnClickListener {
            Log.d("Main","Try to select photo")

            val intent =Intent(Intent.ACTION_PICK)
            intent.type = "images/*"
            startActivityForResult(intent,0)
        }
    }

    private fun performRegister(){
        val name = username_registration.text.toString()
        val email =useremail_registration.text.toString()
        val password =userpassword_registration.text.toString()
        if(email.isEmpty() || password.isEmpty()){
            Toast.makeText(this,"Please Enter email and pasword",Toast.LENGTH_SHORT).show()
            return
        }

        Log.d("MainActivity","Name is :" +name)
        Log.d("MainActivity","Email is :" +email)
        Log.d("MainActivity", "Password is :$password")
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password)

            .addOnCompleteListener{
                if(!it.isSuccessful ) return@addOnCompleteListener
                Log.d("Main","Successfully created user with uid: ${it.result?.user?.uid}")
            }
            .addOnFailureListener {
                Log.d("Main","Failed to create user : ${it.message}")
                Toast.makeText(this,"Failed to create use",Toast.LENGTH_SHORT).show()


            }

    }
}