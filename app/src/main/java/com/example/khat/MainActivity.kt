package com.example.khat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerbutton_registration.setOnClickListener {

            val name = username_registration.text.toString()
            val email =useremail_registration.text.toString()
            val pass =userpassword_registration.text.toString()

            Log.d("MainActivity","Name is :" +name)
            Log.d("MainActivity","Email is :" +email)
            Log.d("MainActivity", "Password is :$pass")
        }

        alreadyaccount_textview.setOnClickListener {
            Log.d("MainActivity","try to login ")
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
    }
}