package com.example.myapplication.activities

import android.content.Intent
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

class UsersActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.users_activity)

        val registrationButton:TextView = findViewById(R.id.textView12)
        val newsButton:TextView = findViewById(R.id.usersActivityNewsButton)


        registrationButton.setOnClickListener {
            val switchActivityIntent = Intent(this, MainActivity::class.java)
            startActivity(switchActivityIntent)
        }

        newsButton.setOnClickListener {
            val switchActivityIntent = Intent(this, NewsActivity::class.java)
            startActivity(switchActivityIntent)
        }



        recyclerView = findViewById(R.id.recyclerView)
        RestClient.initClient()

        RestClient.reqResApi.getUsers(2).enqueue(object : Callback<ReqResData<List<User>>>{

            override fun onResponse(
                call: Call<ReqResData<List<User>>>,
                response: Response<ReqResData<List<User>>>
            ) {
                if (response.isSuccessful){
                    response.body()?.data?.let {
                        recyclerView.adapter = UserRecyclerAdapter(it)
                        recyclerView.layoutManager = LinearLayoutManager(this@UsersActivity)
                    }
                }
            }

            override fun onFailure(call: Call<ReqResData<List<User>>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}