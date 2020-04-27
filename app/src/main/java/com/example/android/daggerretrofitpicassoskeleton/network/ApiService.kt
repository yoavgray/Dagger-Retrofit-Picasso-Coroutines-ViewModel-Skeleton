package com.example.android.daggerretrofitpicassoskeleton.network

import com.example.android.daggerretrofitpicassoskeleton.data.Character
import com.example.android.daggerretrofitpicassoskeleton.data.SearchResult
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("character")
    suspend fun fetchCharacters(@Query(value = "page") page: Int): SearchResult
}
