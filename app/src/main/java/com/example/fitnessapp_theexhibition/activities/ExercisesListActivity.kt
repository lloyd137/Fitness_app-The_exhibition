package com.example.fitnessapp_theexhibition.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.example.fitnessapp_theexhibition.R
import com.example.fitnessapp_theexhibition.activities.details.ExerciseDetailScreen
import com.example.fitnessapp_theexhibition.adapters.ExerciseAdapter
import com.example.fitnessapp_theexhibition.models.Exercise
import com.example.fitnessapp_theexhibition.providers.ExerciseProvider

class ExercisesListActivity : AppCompatActivity() {

    private lateinit var exercisesList: ListView
    private lateinit var exercisesAdapter: ExerciseAdapter
    private var exercises: ArrayList<Exercise> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercises_list)

        exercises.addAll(ExerciseProvider.exercises)
        exercisesList = findViewById(R.id.exercisesList)
        exercisesAdapter = ExerciseAdapter(this, exercises)
        exercisesList.adapter = exercisesAdapter

        exercisesList.setOnItemClickListener { parent, view, position, id ->
            val intent: Intent = Intent(this, ExerciseDetailScreen::class.java).apply {
                putExtra("exercise", exercises[position].name)
            }
        }
    }
}
