package com.example.fitnessapp_theexhibition.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.fitnessapp_theexhibition.R

class CreateWorkoutActivity : AppCompatActivity() {

    lateinit var workoutName: EditText
    lateinit var description: EditText
    lateinit var cancelButton: Button
    lateinit var toExercisesListButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_workout)

        workoutName = findViewById(R.id.workoutNameEditText)
        description = findViewById(R.id.descriptionEditText)
        cancelButton = findViewById(R.id.returnFromCreateButton)
        toExercisesListButton = findViewById(R.id.createExerciseListButton)

        cancelButton.setOnClickListener {
            finish()
        }

        toExercisesListButton.setOnClickListener {
            //check if description and name fields aren't empty
             if (workoutName.text.toString() == "" || description.text.toString() == ""){
                Toast.makeText(applicationContext, getString(R.string.empty_fields), Toast.LENGTH_LONG).show()
            } else {
                val intent:Intent = Intent(this, CreateExercisesListActivity::class.java).apply {
                    putExtra("workoutName", workoutName.text.toString())
                    putExtra("workoutDescription", description.text.toString())
                }

                startActivity(intent)
            }
        }
    }
}
