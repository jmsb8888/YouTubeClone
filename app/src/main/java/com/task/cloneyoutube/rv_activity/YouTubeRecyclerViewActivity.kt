package com.task.cloneyoutube.rv_activity

import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.task.cloneyoutube.NameChanel
import com.task.cloneyoutube.R
import com.task.cloneyoutube.databinding.ActivityHomeYoutubeRvBinding
import com.task.cloneyoutube.databinding.ActivityMainBinding
import com.task.cloneyoutube.rv_activity.adapters.RVAdapterVideos
import com.task.cloneyoutube.rv_activity.homeviewmodel.HomeViewModel
import kotlinx.coroutines.launch
import kotlin.random.Random

class YouTubeRecyclerViewActivity: AppCompatActivity() {

    private lateinit var binding: ActivityHomeYoutubeRvBinding
    private val viewmodel: HomeViewModel by viewModels()
    private lateinit var adapter:  RVAdapterVideos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeYoutubeRvBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAdapter()
        initListeners()
        initUIStateLifecycle()
    }

    private fun initAdapter() {
        adapter = RVAdapterVideos()
    }
    private fun initListeners() {
        binding.btnGetVideos.setOnClickListener {
            viewmodel.setData()
        }
    }

    private fun initUIStateLifecycle() {
        lifecycleScope.launch {
            viewmodel.videoList.collect { videoList ->
                adapter.updateData(videoList)

            }
        }
    }
}