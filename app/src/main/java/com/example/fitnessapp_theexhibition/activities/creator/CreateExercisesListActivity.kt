package com.example.fitnessapp_theexhibition.activities.creator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.*
import com.example.fitnessapp_theexhibition.R
import com.example.fitnessapp_theexhibition.adapters.WorkoutCreatorAdapter
import com.example.fitnessapp_theexhibition.models.Exercise
import com.example.fitnessapp_theexhibition.models.WorkoutExercise
import com.example.fitnessapp_theexhibition.providers.ExerciseProvider
import com.example.fitnessapp_theexhibition.providers.WorkoutCreatorProvider

class CreateExercisesListActivity : AppCompatActivity() {

    lateinit var list: ListView
    lateinit var backButton: Button
    lateinit var addRest: Button
    lateinit var editConfirmButton: Button
    lateinit var seconds: EditText
    lateinit var totalTime: TextView
    lateinit var totalAmount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_exercises_list)

        init()
    }

    private fun init() {
        totalTime = findViewById(R.id.totalCreatorTime)
        totalAmount = findViewById(R.id.amountOfExercises)

        updateData()

        backButton = findViewById(R.id.returnToNames)
        addRest = findViewById(R.id.addpause)
        editConfirmButton = findViewById(R.id.editConfirmButton)
        seconds = findViewById(R.id.createTime)
        list = findViewById(R.id.addExercisesList)
        list.adapter = WorkoutCreatorAdapter(ExerciseProvider.exercises, this)

        seconds.setText(WorkoutCreatorProvider.exerciseDuration.toString())
        seconds.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0.toString() != "" ) {
                    WorkoutCreatorProvider.exerciseDuration = p0.toString().toInt()
                }
            }
        })

        //Go back
        backButton.setOnClickListener {
            startActivity(Intent(this, CreateWorkoutActivity::class.java))
            finish()
        }

        //Rest button
        addRest.setOnClickListener {
            //Check if exercise time is configured
            if (seconds.text.toString() == "") {
                //Scenario one: Empty time field
                Toast.makeText(
                    applicationContext,
                    getString(R.string.empty_time),
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                //Scenario two: Add break to exercises list
                WorkoutCreatorProvider.currentExercisesList.add(
                    WorkoutExercise(
                        Exercise("Break", "", ""),
                        seconds.text.toString().toInt()
                    )
                )
                updateData()
            }

            //Next activity button
            editConfirmButton.setOnClickListener {
                startActivity(Intent(this, EditConfirmWorkoutActivity::class.java))
                finish()
            }
        }
    }

    private fun getTotalTime(): String {
        var totalWorkoutTime: Int = 0
        for (exercise in WorkoutCreatorProvider.currentExercisesList) {
            totalWorkoutTime += exercise.time
        }

        val minutes: Int = totalWorkoutTime / 60
        val secondsLeft: Int = totalWorkoutTime % 60

        return "$minutes:$secondsLeft"
    }

    fun updateData(){
        totalAmount.text = WorkoutCreatorProvider.currentExercisesList.size.toString()
        totalTime.text = getTotalTime()
    }
}
