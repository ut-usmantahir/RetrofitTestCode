package com.example.myapplication.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.myapplication.model.Movie
import com.example.myapplication.R
import kotlinx.android.synthetic.main.layout_movie_item.view.*

class MyMovieAdapter(private val context: Context, private val movieList: MutableList<Movie>): RecyclerView.Adapter<MyMovieAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.layout_movie_item,parent,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

//Just to make progress bar
    fun proBar(): Drawable{
        val circularProgressDrawable = CircularProgressDrawable(context)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()

        return circularProgressDrawable!!
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {


        Glide.with(context)
            .load(movieList[position].imageurl)
            .apply(RequestOptions()
                    .placeholder(proBar()))
            .into(holder.image);
       // Picasso.get().load(movieList[position].imageurl).into(holder.image)
        holder.txt_name.text = movieList[position].name
        holder.txt_team.text = movieList[position].team
        holder.createdby.text = movieList[position].createdby
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        var image: ImageView
        var txt_name: TextView
        var txt_team: TextView
        var createdby: TextView

        init {
            image = itemView.image_movie
            txt_name = itemView.txt_name
            txt_team = itemView.txt_team
            createdby = itemView.txt_createdby

        }

    }
}