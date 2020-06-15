package com.example.fitnessapp_theexhibition.activities.intro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.fitnessapp_theexhibition.R

class SplashScreenActivity : AppCompatActivity() {

    // This is the loading time of the splash screen
    private val splashTime: Long = 2000 // 2 sec

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed({
            // This method will be executed once the timer is over
            // Start your app main activity

            startActivity(Intent(this, IntroTextActivity::class.java))

            // close this activity
            finish()
        }, splashTime)
    }
}

