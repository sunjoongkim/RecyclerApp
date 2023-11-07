package com.report.recyclerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.report.recyclerapp.data.Content

class BookActivity : AppCompatActivity() {
    var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)

        recyclerView = findViewById(R.id.book_recycler_view)
    }

    override fun onResume() {
        super.onResume()

        recyclerView?.layoutManager = GridLayoutManager(this, 2)

        val adapter = BookAdapter(MainActivity.File.contentList)
        recyclerView?.adapter = adapter
    }
}

class BookAdapter(private val movieList: List<Content>) :
    RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    class BookViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val thumbnail: ImageView = view.findViewById(R.id.image_thumbnail)
        val title: TextView = view.findViewById(R.id.text_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.book_item, parent, false)
        return BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val movie = movieList[position]
        holder.thumbnail.setImageBitmap(movie.thumbnail)
        holder.title.text = movie.title
    }

    override fun getItemCount(): Int = movieList.size
}