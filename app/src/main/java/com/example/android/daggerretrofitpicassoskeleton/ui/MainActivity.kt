package com.example.android.daggerretrofitpicassoskeleton.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.daggerretrofitpicassoskeleton.MyApp
import com.example.android.daggerretrofitpicassoskeleton.R
import kotlinx.android.synthetic.main.activity_main.characterRecyclerView
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private val adapter = CharactersAdapter()
    private var fetchCharactersJob: Job? = null

    @Inject lateinit var viewModelFactory: MainViewModelFactory

    private val viewModel: MainViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (applicationContext as MyApp).component.inject(this)

        setViews()

        if (viewModel.page == 1) {
            fetchCharactersJob = lifecycleScope.launch {
                val characters = viewModel.fetchCharacters()
                adapter.addCharacters(characters)
            }
        } else {
            adapter.addCharacters(viewModel.characters)
        }

    }

    private fun setViews() {
        characterRecyclerView.adapter = adapter
        characterRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                if (fetchCharactersJob?.isActive == true) return

                val layoutManager = (recyclerView.layoutManager as? LinearLayoutManager)
                layoutManager?.let {
                    val visibleItemCount = layoutManager.childCount
                    val totalItemCount = layoutManager.itemCount
                    val pastVisibleItemCount = layoutManager.findFirstVisibleItemPosition()

                    if (pastVisibleItemCount + visibleItemCount >= totalItemCount - THRESH) {
                        fetchCharactersJob = lifecycleScope.launch {
                            val characters = viewModel.fetchCharacters()
                            adapter.addCharacters(characters)
                        }
                    }
                }
            }
        })
    }
}

const val THRESH = 3
