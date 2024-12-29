package com.adityaproj.panda_tune

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiInterface {

    @Headers(
        "x-rapidapi-key: 3655b5341bmsh6afe4aa13f37350p1fdb3bjsn088a02baa623",
        "x-rapidapi-host: deezerdevs-deezer.p.rapidapi.com"
    )
    @GET("search")
    fun getData(@Query("q") query: String): Call<MyData>
}
