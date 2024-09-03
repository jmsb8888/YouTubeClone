package com.task.cloneyoutube

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.task.cloneyoutube.rv_activity.YouTubeRecyclerViewActivity

class MainActivity : AppCompatActivity() {
    private lateinit var secuence_videos: LinearLayout
    private val listVideos = arrayListOf<NameChanel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        AddDataVideo()
        addVideos()
    }

    private fun AddDataVideo() {
        for (i in 0 until 10) {
            listVideos.add(NameChanel("Canal $i", "${i+300} k vistas", "hace $i semanas"))
        }
    }

    private fun addVideos() {
        listVideos.forEach { vid ->

            val VideoView = layoutInflater.inflate(R.layout.home_youtube, null)

            val tvChanel: TextView = VideoView.findViewById(R.id.NameChanel)
            tvChanel.text = vid.NameVideo

            val tvQuantityVisits: TextView = VideoView.findViewById(R.id.QuantityVisits)
            tvQuantityVisits.text = vid.Visits
            val tvDate: TextView = VideoView.findViewById(R.id.DateCreate)
            tvDate.text = vid.DateCreation
            secuence_videos.addView(VideoView)
        }
    }

    private fun initViews() {
        secuence_videos = findViewById(R.id.ll_videos)
        findViewById<Button>(R.id.btn_home_youtube_rv).setOnClickListener {
            startActivity(Intent(this, YouTubeRecyclerViewActivity::class.java))
        }
    }
}