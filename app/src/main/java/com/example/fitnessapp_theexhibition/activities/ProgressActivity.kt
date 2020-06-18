package com.example.fitnessapp_theexhibition.activities

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.fitnessapp_theexhibition.R

class ProgressActivity : AppCompatActivity() {

    lateinit var activeTime: TextView
    lateinit var totalWorkout: TextView
    lateinit var preferences: SharedPreferences
    lateinit var returnButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress)

        activeTime = findViewById(R.id.activeTime)
        totalWorkout = findViewById(R.id.totalWorkouts)
        preferences = getSharedPreferences("progress", Context.MODE_PRIVATE)
        returnButton = findViewById(R.id.returnButton)

        activeTime.text = getTimeStamp(preferences.getInt("totalTime", 0))
        totalWorkout.text = preferences.getInt("totalWorkouts", 0).toString()
        returnButton.setOnClickListener {
            finish()
        }
    }

    private fun getTimeStamp(time: Int): String {
        val minutes: Int = time / 60
        val secondsLeft: Int = time % 60


        return if (secondsLeft > 10) {
            println(
                "$minutes:$secondsLeft"
            )
            "$minutes:$secondsLeft"
        } else {
            println(            "$minutes:0$secondsLeft"
            )
            "$minutes:0$secondsLeft"
        }
    }
}