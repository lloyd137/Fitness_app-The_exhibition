package com.example.fitnessapp_theexhibition.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.fitnessapp_theexhibition.R

class WorkoutFinishedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout_finished)

        val workoutName: TextView = findViewById(R.id.finishMessage)
        val finishButton: Button = findViewById(R.id.finishWorkoutbutton)
        workoutName.text = intent.getStringExtra("workoutName")

        finishButton.setOnClickListener {
            finish()
        }

    }
}
