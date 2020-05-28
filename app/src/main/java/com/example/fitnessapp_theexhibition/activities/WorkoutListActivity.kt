package com.example.fitnessapp_theexhibition.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.example.fitnessapp_theexhibition.R
import com.example.fitnessapp_theexhibition.activities.details.WorkoutDetailScreen
import com.example.fitnessapp_theexhibition.adapters.WorkoutListAdapter
import com.example.fitnessapp_theexhibition.models.Workout
import com.example.fitnessapp_theexhibition.providers.WorkoutProvider

class WorkoutListActivity : AppCompatActivity() {

    private lateinit var workoutList:ListView
    private lateinit var workoutAdapter: WorkoutListAdapter
    private var workouts:ArrayList<Workout> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout_list)

        workouts.addAll(WorkoutProvider.workouts)

        workoutList = findViewById<ListView>(R.id.workoutList)
        workoutAdapter = WorkoutListAdapter(this, workouts )
        workoutList.adapter = workoutAdapter


        workoutList.setOnItemClickListener { parent, view, position, id ->
            val intent: Intent = Intent(this, WorkoutDetailScreen::class.java).apply {
                putExtra("workoutName", workouts[position].name)
            }
            startActivity(intent)
        }
    }
}
