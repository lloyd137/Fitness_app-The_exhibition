package com.example.fitnessapp_theexhibition.activities.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fitnessapp_theexhibition.R

class ExerciseDetailScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise_detail_screen)

        val exerciseName:String = intent.getStringExtra("exercise")
        this.title = exerciseName

    }
}
