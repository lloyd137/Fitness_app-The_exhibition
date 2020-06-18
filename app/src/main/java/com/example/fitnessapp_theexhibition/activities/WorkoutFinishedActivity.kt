package com.example.fitnessapp_theexhibition.activities

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.fitnessapp_theexhibition.R
import com.example.fitnessapp_theexhibition.providers.WorkoutProvider

class WorkoutFinishedActivity : AppCompatActivity() {

    lateinit var bearImage: ImageView
    lateinit var timer: CountDownTimer
    var image: Boolean = true
    lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout_finished)

        val workoutName: TextView = findViewById(R.id.finishMessage)
        val finishButton: Button = findViewById(R.id.finishWorkoutbutton)
        workoutName.text = intent.getStringExtra("workoutName")

        //Update shared preferences
        preferences = getSharedPreferences("progress", Context.MODE_PRIVATE)
        updateProgress(
            WorkoutProvider.findWorkoutByName(intent.getStringExtra("workoutName")).getTotalTime()
        )

        bearImage = findViewById(R.id.bearFinish)

        timer = object : CountDownTimer(2147483647, 1000) {

            override fun onFinish() {
            }

            override fun onTick(millisUntilFinished: Long) {
                if (image) {
                    image = false
                    bearImage.setImageResource(R.drawable.workout_done_normal)
                } else {
                    image = true
                    bearImage.setImageResource(R.drawable.workout_complete)
                }
            }
        }
        timer.start()

        finishButton.setOnClickListener {
            finish()
        }
    }

    private fun updateProgress(elevation: Int) {
        //Update total time
        if (preferences.contains("totalTime")) {
            var totalTime = preferences.getInt("totalTime", -1)

            println("key exists, old value = $totalTime, elevation = $elevation")
            println("totaltime = ${totalTime + elevation}")

            //Overwrite old value with new value
            preferences.edit().putInt("totalTime", totalTime + elevation).apply()
        } else {
            //Make new key value pair
            preferences.edit().putInt("totalTime", elevation).apply()

            println("Made new pair, new value is $elevation")
        }

        //Update amount of workouts
        if (preferences.contains("totalWorkouts")) {
            //Update value
            var totalWorkouts = preferences.getInt("totalWorkouts", -1)

            println("old value totalWorkouts = $totalWorkouts, New should be ${totalWorkouts + 1}")

            //Overwrite
            preferences.edit().putInt("totalWorkouts", totalWorkouts + 1).apply()
        } else {
            preferences.edit().putInt("totalWorkouts", 1).apply()

            println("key doesn't exist yet, new value = 1")
        }
    }
}
