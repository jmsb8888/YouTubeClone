package com.task.cloneyoutube

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

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
/// comentario de pruebas uso git
    private fun AddDataVideo() {
        for (i in 0 until 10) {
            listVideos.add(NameChanel("Canal $i", "${i+300} k vistas", "hace $i semanas"))
        }
    }

    private fun addVideos() {
        listVideos.forEach { vid ->

            val VideoView = layoutInflater.inflate(R.layout.home_youtube, null)

            val tvChanel: TextView = VideoView.findViewById(R.id.NameChanel)
            tvChanel.text = vid.NameChanel

            val tvQuantityVisits: TextView = VideoView.findViewById(R.id.QuantityVisits)
            tvQuantityVisits.text = vid.Visits

            val tvDate: TextView = VideoView.findViewById(R.id.DateCreate)
            tvDate.text = vid.DateCreation

            secuence_videos.addView(VideoView)
        }
    }

    private fun initViews() {
        secuence_videos = findViewById(R.id.secuence_videos)
    }
}