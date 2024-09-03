package com.task.cloneyoutube.rv_activity.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.task.cloneyoutube.NameChanel
import com.task.cloneyoutube.R

class RVAdapterVideos(private var dataChanel: List<NameChanel> = emptyList()) :
    RecyclerView.Adapter<RVAdapterVideos.VideosViewHolder>() {


    class VideosViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val NameVideo: TextView = view.findViewById(R.id.NameVideo)
        val NameChanel: TextView = view.findViewById(R.id.NameChanel)
        val QuantityVisits: TextView = view.findViewById(R.id.QuantityVisits)
        val DateCreate: TextView = view.findViewById(R.id.DateCreate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideosViewHolder {

        val videosView = LayoutInflater.from(parent.context)
            .inflate(R.layout.home_youtube, parent, false)
        return VideosViewHolder(videosView)
    }

    override fun onBindViewHolder(holder: VideosViewHolder, position: Int) {
        val video = dataChanel[position]
        holder.NameVideo.text = video.NameVideo
       // holder.NameChanel.text = "Chanel Name"
        holder.QuantityVisits.text = video.Visits
        holder.DateCreate.text = video.DateCreation
    }

    override fun getItemCount(): Int = dataChanel.size

    fun updateData(newData: List<NameChanel>) {
        dataChanel = newData
        notifyDataSetChanged()
    }
}