package com.example.fitnessapp_theexhibition.activities.creator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import com.example.fitnessapp_theexhibition.R
import com.example.fitnessapp_theexhibition.adapters.EditWorkoutAdapter
import com.example.fitnessapp_theexhibition.providers.WorkoutCreatorProvider
import com.example.fitnessapp_theexhibition.providers.WorkoutProvider

class EditConfirmWorkoutActivity : AppCompatActivity() {

    lateinit var editWorkoutList:ListView
    lateinit var backButton:Button
    lateinit var saveButton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_confirm_workout)

        editWorkoutList = findViewById(R.id.editWorkoutList)
        editWorkoutList.adapter = EditWorkoutAdapter(WorkoutCreatorProvider.currentExercisesList, this)

        backButton = findViewById(R.id.returnToAddExercisesButton)
        backButton.setOnClickListener {
            startActivity(Intent(this, CreateExercisesListActivity::class.java))
            finish()
        }

        saveButton = findViewById(R.id.saveWorkout)
        saveButton.setOnClickListener {
            //Add workout to workout provider
            WorkoutProvider.addWorkout(WorkoutCreatorProvider.currentWorkout)

            //Empty the current custom workout for next make
            WorkoutCreatorProvider.clearWorkout()

            finish()
        }
    }
}