package com.example.fitnessapp_theexhibition.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.VideoView
import com.example.fitnessapp_theexhibition.R

class IntroAnimationActivity : AppCompatActivity() {
    lateinit var videoView:VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro_animation)

        videoView = findViewById(R.id.videoView)
        videoView.setVideoPath("android.resource://$packageName/${R.raw.intro_video}")
        videoView.start()

        videoView.setOnCompletionListener {
            videoView.visibility = View.INVISIBLE
            val intent:Intent = Intent(this, MainMenuActivity::class.java)
            startActivity(intent)
        }

        videoView.setOnClickListener {
            videoView.visibility = View.INVISIBLE
            val intent:Intent = Intent(this, MainMenuActivity::class.java)
            startActivity(intent)
        }
    }
}
