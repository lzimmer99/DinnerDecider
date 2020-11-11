package com.example.dinnerdecider

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.activity_y_t.*


class YTActivity : YouTubeBaseActivity() {

    companion object {
        //val VIDEO_ID: String = "9DQ5QaAsCDs"
        const val YOUTUBE_API_KEY: String = "AIzaSyAsD5cg28hy42bnDZJmkgPoaaUshok8dp4"
        val FOOD_Name = "food_passer"
    }


    private lateinit var youtubePlayerInit: YouTubePlayer.OnInitializedListener


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_y_t)

        initUI()
    }

    private fun initUI() {

        val yt_arr: Map<String, String> = mapOf(
            "Indisches Curry" to "9DQ5QaAsCDs",
            "Burger" to "vCXg4tuMpe4",
            "Maultaschen" to "xA5P75X_xGE",
            "Khachapuri" to "UgofBvujNHA",
            "Minestrone" to "Usp-Rgyn2kc",
            "Moussaka" to "gIZKAuUh34I"

        )
        val cont = intent.getStringExtra(FOOD_Name)
        val vidId = yt_arr[cont]



        youtubePlayerInit = object : YouTubePlayer.OnInitializedListener {
            override fun onInitializationSuccess(
                p0: YouTubePlayer.Provider?,
                youtubePlayer: YouTubePlayer?,
                p2: Boolean
            ) {
                youtubePlayer?.loadVideo(vidId)
            }

            override fun onInitializationFailure(
                p0: YouTubePlayer.Provider?,
                p1: YouTubeInitializationResult?
            ) {
                Toast.makeText(
                    applicationContext,
                    "Ups...Ein Problem ist aufgetreten!! ",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        btnPlay.setOnClickListener(View.OnClickListener {
            youtubePlayer.initialize(YOUTUBE_API_KEY, youtubePlayerInit)
        })

        
    }

}
