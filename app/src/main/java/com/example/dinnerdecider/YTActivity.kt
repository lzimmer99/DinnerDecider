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
        val VIDEO_ID: String = "YqggV_wGhM0";
        val YOUTUBE_API_KEY: String = "AIzaSyAsD5cg28hy42bnDZJmkgPoaaUshok8dp4"
    }

    lateinit var youtubePlayerInit: YouTubePlayer.OnInitializedListener


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_y_t)

        initUI()
    }

    private fun initUI() {
        youtubePlayerInit = object : YouTubePlayer.OnInitializedListener {
            override fun onInitializationSuccess(p0: YouTubePlayer.Provider?, youtubePlayer: YouTubePlayer?, p2: Boolean) {
                youtubePlayer?.loadVideo(VIDEO_ID)
            }

            override fun onInitializationFailure(p0: YouTubePlayer.Provider?, p1: YouTubeInitializationResult?) {
                Toast.makeText(applicationContext, "Something went wrong !! ", Toast.LENGTH_SHORT).show()
            }
        }

        btnPlay.setOnClickListener(View.OnClickListener { v ->
            youtubePlayer.initialize(YOUTUBE_API_KEY, youtubePlayerInit)
        })
    }

}
