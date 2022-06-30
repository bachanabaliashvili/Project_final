package com.example.myapplication.activities

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import kotlinx.android.synthetic.main.users_activity.*

class NewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.news_activity)

        val registrationButton:TextView = findViewById(R.id.textView12)
        val studentButton:TextView = findViewById(R.id.textView11)

        registrationButton.setOnClickListener {
            val switchActivityIntent = Intent(this, MainActivity::class.java)
            startActivity(switchActivityIntent)
        }

        studentButton.setOnClickListener{
            val switchActivityIntent = Intent(this, UsersActivity::class.java)
            startActivity(switchActivityIntent)
        }


    }
}