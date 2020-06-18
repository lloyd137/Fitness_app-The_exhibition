package com.example.fitnessapp_theexhibition.activities

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.fitnessapp_theexhibition.R
import com.example.fitnessapp_theexhibition.activities.creator.CreateWorkoutActivity
import com.example.fitnessapp_theexhibition.models.Workout
import com.example.fitnessapp_theexhibition.models.WorkoutExercise
import com.example.fitnessapp_theexhibition.providers.ExerciseProvider
import com.example.fitnessapp_theexhibition.providers.WorkoutProvider
import kotlin.system.exitProcess

class MainMenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(R.anim.fadein, R.anim.fadeout)
        setContentView(R.layout.activity_main_menu)

        //Views
        val workoutButtonListButton: Button = findViewById(R.id.workoutListButton)
        val exercisesListButton: Button = findViewById(R.id.exercisesListButton)
        val createWorkoutButton: Button = findViewById(R.id.createWorkoutButton)
        val progressButton: Button = findViewById(R.id.progressButton)
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

        progressButton.setOnClickListener { view ->
            onProgressButtonClick(view)
        }

        exitButton.setOnClickListener {
            closeApp()
        }
    }

    override fun onBackPressed() {
        closeApp()
    }

    private fun closeApp() {

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Are you sure you want to quit?")
        builder.setMessage("Click Yes to close the app. Click No to return to the main menu.")

        builder.setPositiveButton("Yes") { dialog, which ->
            //finish activity a.k.a. close app
            moveTaskToBack(true);
            exitProcess(-1)
        }

        builder.setNegativeButton("No") { dialog, which ->
        }

        builder.show()
    }

    private fun onProgressButtonClick(button: View) {
        startActivity(Intent(this, ProgressActivity::class.java))
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

