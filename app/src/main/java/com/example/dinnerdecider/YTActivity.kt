
package com.example.dinnerdecider

import android.os.Bundle
import android.widget.Toast
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.activity_y_t.*


@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class YTActivity : YouTubeBaseActivity() {

    companion object {
        const val YOUTUBE_API_KEY: String = "AIzaSyAsD5cg28hy42bnDZJmkgPoaaUshok8dp4"
        const val FOOD_Name = "food_passer"
    }
    // Hier zum einen den API-Key und einen default String für Food_Name

    private lateinit var youtubePlayerInit: YouTubePlayer.OnInitializedListener


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_y_t)

        initUI()
    }

    private fun initUI() {

        // Array ähnlich Python Dictionary mit den zu den Gerichten zugehörigen Youtube-Video-Keys
        val ytarr: Map<String, String> = mapOf(
            "Indisches Curry" to "9DQ5QaAsCDs",
            "Burger" to "vCXg4tuMpe4",
            "Maultaschen" to "xA5P75X_xGE",
            "Khachapuri" to "UgofBvujNHA",
            "Minestrone" to "Usp-Rgyn2kc",
            "Moussaka" to "gIZKAuUh34I"
        )

        val vidId = ytarr[intent.getStringExtra(FOOD_Name)]
        // über FOOD_Name wird die entsprechende Video-ID aus ytarr ausgelesen


        youtubePlayerInit = object : YouTubePlayer.OnInitializedListener {
            override fun onInitializationSuccess(
                p0: YouTubePlayer.Provider?,
                // Provides YoutubePlayer interface
                youtubePlayer: YouTubePlayer?,
                p2: Boolean
            ) {
                youtubePlayer?.loadVideo(vidId)
                // Hier wird das Video mit der entsprechenden  VideoID  geladen
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

        // Klick auf den Button spielt das Video ab
        btnPlay.setOnClickListener{
            youtubePlayer.initialize(YOUTUBE_API_KEY, youtubePlayerInit)
        }


    }

}
