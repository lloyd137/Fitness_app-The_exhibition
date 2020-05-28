package com.example.fitnessapp_theexhibition.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.example.fitnessapp_theexhibition.R
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

        exercises.add(
            Exercise(
                "Crunches",
                "The crunch is one of the most popular abdominal exercises. It involves the entire abs, but primarily it works the rectus abdominis muscle and also works the obliques. It allows both building six-pack abs, and tightening the belly.",
                "Abs"
            )
        )

        //Is empty, thus commented out
//        exercises.addAll(ExerciseProvider.exercises)

        exercisesList = findViewById(R.id.exercisesList)
        exercisesAdapter = ExerciseAdapter(this, exercises)
    }
}
