package com.report.recyclerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.report.recyclerapp.data.Content

class ShowActivity : AppCompatActivity() {
    var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)

        recyclerView = findViewById(R.id.show_recycler_view)
    }

    override fun onResume() {
        super.onResume()

        recyclerView?.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val adapter = ShowAdapter(MainActivity.File.contentList)
        recyclerView?.adapter = adapter
    }
}

class ShowAdapter(private val movieList: List<Content>) :
    RecyclerView.Adapter<ShowAdapter.ShowViewHolder>() {

    class ShowViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val thumbnail: ImageView = view.findViewById(R.id.image_thumbnail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.show_item, parent, false)
        return ShowViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShowViewHolder, position: Int) {
        val movie = movieList[position]
        holder.thumbnail.setImageBitmap(movie.thumbnail)
    }

    override fun getItemCount(): Int = movieList.size
}