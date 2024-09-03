package com.task.cloneyoutube.rv_activity

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.task.cloneyoutube.NameChanel
import com.task.cloneyoutube.R
import com.task.cloneyoutube.rv_activity.adapters.RVAdapterVideos
import kotlin.random.Random

class YouTubeRecyclerViewActivity: AppCompatActivity() {
    private lateinit var rvVideos: RecyclerView
    private lateinit var btnGetVideos: Button
    private lateinit var btnDeleteVideos: Button
    private lateinit var btnEditVideos: Button
    private lateinit var rvAdapterVideos: RVAdapterVideos

    private val listVideos = arrayListOf<NameChanel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_youtube_rv)
        initViews()
    }

    private fun initViews() {
        btnGetVideos = findViewById(R.id.btnGetVideos)
        btnGetVideos.setOnClickListener {
            AddDataVideo()
            rvAdapterVideos.notifyDataSetChanged()
        }

        btnDeleteVideos = findViewById(R.id.btnDeleteVideos)
        btnDeleteVideos.setOnClickListener {
            val videoToRemove = Random.nextInt(from = 0, until = listVideos.size)
            listVideos.removeAt(videoToRemove)
            rvAdapterVideos.notifyItemRemoved(videoToRemove)
        }
        btnEditVideos = findViewById(R.id.btnEditVideos)
        btnEditVideos.setOnClickListener {
            val videoToEdit = Random.nextInt(from = 0, until = listVideos.size)
            val video = listVideos[videoToEdit].copy(
                NameVideo = "Canal $videoToEdit",
                Visits = "${videoToEdit + 300} k vistas",
                DateCreation = "hace $videoToEdit semanas"
            )
            listVideos[videoToEdit] = video
            rvAdapterVideos.notifyItemChanged(videoToEdit)
        }
        rvVideos = findViewById(R.id.rvVideos)
        initRv()
    }

    private fun initRv() {
        rvAdapterVideos = RVAdapterVideos(dataChanel = listVideos)
        rvVideos.apply {
            layoutManager =
                LinearLayoutManager(this@YouTubeRecyclerViewActivity, LinearLayoutManager.VERTICAL, false)
            adapter = rvAdapterVideos
        }
    }

    private fun AddDataVideo() {
        for (i in 0 until 4) {
            listVideos.add(NameChanel("Canal $i", "${i + 300} k vistas", "hace $i semanas"))
        }
    }
}