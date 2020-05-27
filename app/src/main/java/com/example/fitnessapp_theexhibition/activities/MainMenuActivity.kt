package com.example.fitnessapp_theexhibition.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.fitnessapp_theexhibition.R

class MainMenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        //Views
        val workoutButtonListButton: Button = findViewById(R.id.workoutListButton)
        val exercisesListButton: Button = findViewById(R.id.exercisesListButton)
        val createWorkoutButton: Button = findViewById(R.id.createWorkoutButton)
        val exitButton: Button = findViewById(R.id.exitButton)

        workoutButtonListButton.setOnClickListener { view ->
            onWorkoutListClick(view)
        }

        exercisesListButton.setOnClickListener { view ->
            onExercisesListButtonClick(view)
        }

        createWorkoutButton.setOnClickListener { view ->
            onCreateWorkoutButtonClick(view)
        }

        exitButton.setOnClickListener {
            //finish activity a.k.a. close app
            finish()
        }

    }

    private fun onWorkoutListClick(button: View) {
        startActivity(Intent(this, WorkoutListActivity::class.java))
    }

    private fun onExercisesListButtonClick(button: View) {
        startActivity(Intent(this, ExercisesListActivity::class.java))
    }

    private fun onCreateWorkoutButtonClick(button: View) {
        startActivity(Intent(this, CreateWorkoutActivity::class.java))
    }
}

