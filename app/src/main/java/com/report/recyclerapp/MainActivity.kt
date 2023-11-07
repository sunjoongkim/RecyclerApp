package com.report.recyclerapp

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import com.report.recyclerapp.data.Content

class MainActivity : AppCompatActivity() {

    private var btnMovie : Button? = null
    private var btnBook : Button? = null
    private var btnShow : Button? = null


    object File {
        val contentList = mutableListOf<Content>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMovie = findViewById(R.id.btn_movie)
        btnMovie?.setOnClickListener(onClickListener)
        btnBook = findViewById(R.id.btn_book)
        btnBook?.setOnClickListener(onClickListener)
        btnShow = findViewById(R.id.btn_show)
        btnShow?.setOnClickListener(onClickListener)
    }

    override fun onResume() {
        super.onResume()

        createContentList()
    }

    private object onClickListener : OnClickListener {
        override fun onClick(view: View?) {

            val context = view?.context
            var intent : Intent? = null

            when (view?.id) {
                R.id.btn_movie -> {
                    intent = Intent(context, MovieActivity::class.java)
                }
                R.id.btn_book -> {
                    intent = Intent(context, BookActivity::class.java)
                }
                R.id.btn_show -> {
                    intent = Intent(context, ShowActivity::class.java)
                }
            }
            if (intent != null)
                context?.startActivity(intent)
        }

    }

    private fun createContentList() {
        File.contentList.clear()

        File.contentList.add(Content(getBitmap("img_1"), "버킷리스트"))
        File.contentList.add(Content(getBitmap("img_2"), "화려한 휴가"))
        File.contentList.add(Content(getBitmap("img_3"), "악마를 보았다"))
        File.contentList.add(Content(getBitmap("img_4"), "타워"))
        File.contentList.add(Content(getBitmap("img_5"), "몽타주"))
        File.contentList.add(Content(getBitmap("img_6"), "화이 (괴물을 삼킨 아이)"))
        File.contentList.add(Content(getBitmap("img_7"), "해무"))
        File.contentList.add(Content(getBitmap("img_8"), "판의미로"))
        File.contentList.add(Content(getBitmap("img_9"), "아이 씨 유"))
        File.contentList.add(Content(getBitmap("img_10"), "퍼즐"))
    }

    private fun getBitmap(img: String) : Bitmap {
        val resourceId = resources.getIdentifier(img, "drawable", packageName)
        val drawable = resources.getDrawable(resourceId, null)
        return (drawable as BitmapDrawable).bitmap
    }
}