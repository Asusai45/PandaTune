package com.adityaproj.panda_tune

import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity6 : AppCompatActivity() {

    lateinit var myRecyclerView: RecyclerView
    lateinit var search: SearchView
    lateinit var myAdapter: MyAdapter
    private var dataList: List<Data> = emptyList() // Initialize as an empty list

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Ensure this is a valid method or replace with correct functionality
        setContentView(R.layout.activity_main6)

        myRecyclerView = findViewById(R.id.recycler)
        search = findViewById(R.id.searchView)

        setupSearchView()

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://deezerdevs-deezer.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getData("eminem")
        retrofitData.enqueue(object : Callback<MyData?> {
            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {
                if (response.isSuccessful) {
                    dataList = response.body()?.data ?: emptyList() // Assign the data to dataList
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

    private fun setupSearchView() {
        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }
        })
    }

    private fun filterList(query: String?) {
        if (query.isNullOrEmpty()) {
            myAdapter.Setfilteredlist(dataList)
        } else {
            val filteredList = dataList.filter {
                it.title.contains(query, ignoreCase = true)
            }

            if (filteredList.isEmpty()) {
                Toast.makeText(this, "No match found", Toast.LENGTH_SHORT).show()
            }

            myAdapter.Setfilteredlist(filteredList)
        }
    }
}






