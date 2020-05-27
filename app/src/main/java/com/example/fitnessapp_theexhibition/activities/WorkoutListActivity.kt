package com.example.fitnessapp_theexhibition.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.example.fitnessapp_theexhibition.R
import com.example.fitnessapp_theexhibition.adapters.WorkoutListAdapter
import com.example.fitnessapp_theexhibition.models.Workout

class WorkoutListActivity : AppCompatActivity() {

    private lateinit var workoutList:ListView
    private lateinit var workouts:ArrayList<Workout>
    private lateinit var workoutAdapter: WorkoutListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout_list)

        workouts = ArrayList<Workout>()
        workouts.add(Workout("Ab crusher", "This is an example for the list"))

        workoutList = findViewById<ListView>(R.id.workoutList)
        workoutAdapter = WorkoutListAdapter(this, workouts )
        workoutList.adapter = workoutAdapter

    }
}
