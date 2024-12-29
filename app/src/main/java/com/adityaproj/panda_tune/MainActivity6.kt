package com.adityaproj.panda_tune

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainActivity6 : AppCompatActivity() {

    lateinit var myRecyclerView: RecyclerView
    lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()  // Ensure this is a valid method or replace with correct functionality
        setContentView(R.layout.activity_main6)

        myRecyclerView = findViewById(R.id.recycler)

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://deezerdevs-deezer.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getData("eminem")
        retrofitData.enqueue(object : Callback<MyData?> {
            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {
                if (response.isSuccessful) {
                    val dataList = response.body()?.data ?: emptyList()  // Null safety check
                    myAdapter = MyAdapter(this@MainActivity6, dataList)
                    myRecyclerView.adapter = myAdapter
                    myRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity6)
                    Log.d("TAG", "onResponse: ${response.body()}")
                } else {
                    Log.e("TAG", "Response Error: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<MyData?>, t: Throwable) {
                Log.e("TAG", "Error: ${t.message}", t)
            }
        })
    }
}







