package com.example.android.daggerretrofitpicassoskeleton.ui

import androidx.lifecycle.ViewModel
import com.example.android.daggerretrofitpicassoskeleton.data.Character
import com.example.android.daggerretrofitpicassoskeleton.network.ApiService
import java.io.IOException

class MainViewModel(private val apiService: ApiService) : ViewModel() {
    var page: Int = 1
    val characters = mutableListOf<Character>()

    suspend fun fetchCharacters(): List<Character> {
        return try {
            return apiService.fetchCharacters(page).results.also { results ->
                page++
                characters.addAll(results)
            }
        } catch (exception: IOException) {
            emptyList()
        }
    }
}
