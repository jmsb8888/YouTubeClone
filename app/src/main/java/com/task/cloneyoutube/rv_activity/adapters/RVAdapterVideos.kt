package com.task.cloneyoutube.rv_activity.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.task.cloneyoutube.NameChanel
import com.task.cloneyoutube.R

class RVAdapterVideos(private val dataChanel: List<NameChanel>) :
    RecyclerView.Adapter<RVAdapterVideos.VideosViewHolder>() {

    class VideosViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvUserName: TextView = view.findViewById(R.id.NameVideo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideosViewHolder {

        val videosView = LayoutInflater.from(parent.context)
            .inflate(R.layout.home_youtube, parent, false)
        return VideosViewHolder(videosView)
    }

    override fun onBindViewHolder(holder: VideosViewHolder, position: Int) {
        holder.tvUserName.text = dataChanel[position].NameVideo
    }

    override fun getItemCount(): Int = dataChanel.size

}