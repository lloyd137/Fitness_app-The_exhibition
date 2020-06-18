package com.example.fitnessapp_theexhibition.activities

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.fitnessapp_theexhibition.R

class ProgressActivity : AppCompatActivity() {

    lateinit var activeTimeHours: TextView
    lateinit var activeTimeMinutes: TextView
    lateinit var activeTimeSeconds: TextView
    lateinit var totalWorkout: TextView
    lateinit var preferences: SharedPreferences
    lateinit var returnButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress)

        activeTimeHours = findViewById(R.id.activeTimeHours)
        activeTimeMinutes = findViewById(R.id.activeTimeMinutes)
        activeTimeSeconds = findViewById(R.id.activeTimeSeconds)
        totalWorkout = findViewById(R.id.totalWorkouts)
        preferences = getSharedPreferences("progress", Context.MODE_PRIVATE)
        returnButton = findViewById(R.id.returnButton)

        setTime()
        totalWorkout.text = preferences.getInt("totalWorkouts", 0).toString()
        returnButton.setOnClickListener {
            finish()
        }
    }

    private fun setTime() {

        val totalTime = preferences.getInt("totalTime", 0)

        val hours: Int = totalTime / 3600
        val remainingTime: Int = totalTime - hours * 3600
        val minutes: Int = remainingTime / 60
        val seconds: Int = remainingTime % 60

        activeTimeHours.text = "$hours Hours"
        activeTimeMinutes.text = "$minutes Minutes"
        activeTimeSeconds.text = "$seconds Seconds"
    }

    private fun getActiveHours(time: Int): String {

        val hours: Int = time / 3600
        val minutes: Int = time / 60
        val secondsLeft: Int = time % 60

        return if (secondsLeft > 10) {
            "$minutes:$secondsLeft"
        } else {
            "$minutes:0$secondsLeft"
        }
    }
}