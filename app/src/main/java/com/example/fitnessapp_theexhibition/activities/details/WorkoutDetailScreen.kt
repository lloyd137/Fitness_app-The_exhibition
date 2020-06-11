package com.example.fitnessapp_theexhibition.activities.details

import android.app.AlertDialog
import android.content.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import com.example.fitnessapp_theexhibition.R
import com.example.fitnessapp_theexhibition.activities.WorkoutExecutionActivity
import com.example.fitnessapp_theexhibition.adapters.WorkoutExercisesAdapter
import com.example.fitnessapp_theexhibition.providers.WorkoutProvider

class WorkoutDetailScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout_detail_screen)

        this.title = intent.getStringExtra("workoutName")
        val exercisesList:ListView = findViewById(R.id.workoutExercisesList)
        val workoutName = intent.getStringExtra("workoutName")
        val workoutId = intent.getIntExtra("id", -1)
        val adapter = WorkoutExercisesAdapter(WorkoutProvider.findWorkoutById(workoutId).exercises, this)
        exercisesList.adapter = adapter

        println(adapter.exercises.size)

        val startButton:Button = findViewById(R.id.startWorkoutButton)
        val cancelButton:Button = findViewById(R.id.cancelWorkoutButton)

        startButton.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Are you ready to start the workout?")
            builder.setMessage("The workout will start if you click yes. Make sure your body is warmed up to prevent injuries.")

            builder.setPositiveButton("Yes!") { dialog, which ->
                //Finish activity
                finish()

                //Start the workout by starting the WorkoutExecutionActivity
                val intent:Intent = Intent(this, WorkoutExecutionActivity::class.java).apply {
                    putExtra("workoutName", workoutName)
                }

                startActivity(intent)
            }

            builder.setNegativeButton("No!") { dialog, which ->

            }

            builder.show()
        }

        cancelButton.setOnClickListener {
            finish()
        }

    }
}
