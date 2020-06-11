package com.example.fitnessapp_theexhibition.activities.creator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.fitnessapp_theexhibition.R
import com.example.fitnessapp_theexhibition.providers.WorkoutCreatorProvider

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

        //Check if previous workout wasn't finished
        if(WorkoutCreatorProvider.currentWorkout.name != ""){
            workoutName.setText(WorkoutCreatorProvider.currentWorkout.name)
        }

        if (WorkoutCreatorProvider.currentWorkout.description != ""){
            description.setText(WorkoutCreatorProvider.currentWorkout.description)
        }

        //Configure textWatcher
        textWatcherConfiguration()

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
                 finish()
            }
        }
    }
    private fun textWatcherConfiguration(){
        workoutName.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                if (p0.toString() != "" ) {
                    WorkoutCreatorProvider.currentWorkout.name = p0.toString()
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })

        description.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                if (p0.toString() != "" ) {
                    WorkoutCreatorProvider.currentWorkout.description = p0.toString()
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
        })
    }
}
