package com.example.android.daggerretrofitpicassoskeleton.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.daggerretrofitpicassoskeleton.di.ApiService
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(private val apiService: ApiService) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(ApiService::class.java).newInstance(apiService)
    }
}
