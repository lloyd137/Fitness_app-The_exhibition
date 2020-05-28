package com.example.fitnessapp_theexhibition.activities.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.example.fitnessapp_theexhibition.R
import com.example.fitnessapp_theexhibition.adapters.WorkoutExercisesAdapter
import com.example.fitnessapp_theexhibition.providers.WorkoutProvider

class WorkoutDetailScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout_detail_screen)

        this.title = intent.getStringExtra("workoutName")
        val exercisesList:ListView = findViewById(R.id.workoutExercisesList)
        val workoutName = intent.getStringExtra("workoutName")
        println(workoutName)
        val adapter = WorkoutExercisesAdapter(WorkoutProvider.findWorkoutByName(title.toString()).exercises, this)
        exercisesList.adapter = adapter

        println(adapter.exercises.size)
    }
}
