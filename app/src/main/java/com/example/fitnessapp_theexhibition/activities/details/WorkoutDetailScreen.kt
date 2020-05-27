package com.example.fitnessapp_theexhibition.activities.details

import android.app.PendingIntent.getActivity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fitnessapp_theexhibition.R

class WorkoutDetailScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout_detail_screen)

        this.title = intent.getStringExtra("workoutName")
    }
}
