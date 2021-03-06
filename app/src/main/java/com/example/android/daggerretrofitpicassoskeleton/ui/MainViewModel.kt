package com.example.android.daggerretrofitpicassoskeleton.ui

import androidx.lifecycle.ViewModel
import com.example.android.daggerretrofitpicassoskeleton.network.ApiService

class MainViewModel(private val apiService: ApiService) : ViewModel() {

    suspend fun fetchSomething(): Any {
        return apiService.fetchSomething("blah")
    }
}
