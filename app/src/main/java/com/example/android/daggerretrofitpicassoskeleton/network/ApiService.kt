package com.example.android.daggerretrofitpicassoskeleton.network

import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/additional/path/{queryParam}?another_query_param=true")
    suspend fun fetchSomething(@Path(value = "queryParam", encoded = true) queryParam: String): Map<String, Any>
}
