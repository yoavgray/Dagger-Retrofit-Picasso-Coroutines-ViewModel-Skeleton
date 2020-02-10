package com.example.android.daggerretrofitpicassoskeleton.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.android.daggerretrofitpicassoskeleton.MyApp
import com.example.android.daggerretrofitpicassoskeleton.R
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject lateinit var viewModelFactory: MainViewModelFactory

    private val viewModel: MainViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (applicationContext as MyApp).component.inject(this)
    }
}
