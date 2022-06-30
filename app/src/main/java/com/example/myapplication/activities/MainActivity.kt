package com.example.myapplication.activities

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.adapters.UserRecyclerAdapter
import com.example.myapplication.api.RestClient
import com.example.myapplication.api.dto.ReqResData
import com.example.myapplication.api.dto.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1:Button = findViewById(R.id.button1);

        button1.setOnClickListener {
            val switchActivityIntent = Intent(this, UsersActivity::class.java)
            startActivity(switchActivityIntent)
        }

//      notification
        val brReceiver: BroadcastReceiver = MyBroadcastReceiver()
        val intFilter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION).apply {
            addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        }
        registerReceiver(brReceiver, intFilter)

    }
}