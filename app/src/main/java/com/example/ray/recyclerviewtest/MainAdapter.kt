package com.example.ray.recyclerviewtest

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.video_row.view.*


class MainAdapter( val homeFeed: HomeFeed) : RecyclerView.Adapter<CustomViewHolder>() {



    //holds number of items
    override fun getItemCount(): Int {
        return homeFeed.videos.size
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomViewHolder {

        val layoutInflater = LayoutInflater.from(p0.context)
        val cellForRow = layoutInflater.inflate(R.layout.video_row, p0, false)
        return CustomViewHolder(cellForRow)
    }


    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val movieTitle = homeFeed.videos.get(position)
        holder.view.textView_Video_Title?.text = movieTitle.name
        holder.view.textView_Channel_Name?.text = movieTitle.channel.name

        val thumbnailImage = holder.view.imageView_Video_Thumbnail
        Picasso.get().load(movieTitle.imageUrl).into(thumbnailImage)

        val profileImage = holder.view.imageView_Channel_Profile
        Picasso.get().load(movieTitle.imageUrl).into(profileImage)
    }

}

class CustomViewHolder(val view: View) : RecyclerView.ViewHolder(view){

    init {
        view.setOnClickListener {
            println("Click heard")

            val intent = Intent(view.context,CourseDetailActivity::class.java)
            view.context.startActivity(intent)
        }
    }

}