package com.example.ray.recyclerviewtest

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // recyclerViewMain.setBackgroundColor(Color.BLUE)
        recyclerViewMain.layoutManager = LinearLayoutManager(this)


        fetchJson()
    }

    fun fetchJson(){
        println("Attempting to fetch JSON")

        val url = "https://api.letsbuildthatapp.com/youtube/home_feed"

        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object:Callback {
            override fun onResponse(call: Call?, response: Response?) {
                val body = response?.body()?.string()
                println(body)

                val gson =GsonBuilder().create()

                val homeFeed = gson.fromJson(body, HomeFeed::class.java)


                runOnUiThread {recyclerViewMain.adapter = MainAdapter(homeFeed)  }

            }
            override fun onFailure(call: Call?, e: IOException?) {
                println("Failed to execute JSON request")


                           }

        }
        )
    }
}
