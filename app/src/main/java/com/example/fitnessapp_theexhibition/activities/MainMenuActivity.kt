package com.example.fitnessapp_theexhibition.activities

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
            moveTaskToBack(true);
            exitProcess(-1)
        }

        ExerciseProvider.generateExercises()
        val workoutExercisesOne: ArrayList<WorkoutExercise> = ArrayList()
        val workoutExerciseTwo: ArrayList<WorkoutExercise> = ArrayList()

        for (exercise in ExerciseProvider.exercises) {
            workoutExercisesOne.add(WorkoutExercise(exercise, 30))
            workoutExerciseTwo.add(WorkoutExercise(exercise, 20))
            println("Exercise added to both lists: " + exercise.name)
        }

        WorkoutProvider.addWorkout(Workout("Body workout medium level", "This is a beginner friendly workout for training your full body", workoutExercisesOne))
        WorkoutProvider.addWorkout(Workout("Body workout easy level", "Burn and fern all over with this high-intensity cardio workout", workoutExerciseTwo))

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

