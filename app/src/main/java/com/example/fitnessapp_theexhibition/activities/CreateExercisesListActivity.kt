package com.example.fitnessapp_theexhibition.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import com.example.fitnessapp_theexhibition.R
import com.example.fitnessapp_theexhibition.adapters.WorkoutCreatorAdapter
import com.example.fitnessapp_theexhibition.models.WorkoutExercise
import com.example.fitnessapp_theexhibition.providers.ExerciseProvider

class CreateExercisesListActivity : AppCompatActivity() {

    lateinit var list: ListView
    lateinit var backButton: Button
    lateinit var addRest: Button
    lateinit var editConfirmButton: Button
    lateinit var seconds:EditText
    lateinit var totalTime:TextView
    lateinit var totalAmount:TextView

    private val customWorkout:ArrayList<WorkoutExercise> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_exercises_list)

        init()


    }

    private fun init() {
        totalTime = findViewById(R.id.totalCreatorTime)
        totalAmount = findViewById(R.id.amountOfExercises)

        totalAmount.text = customWorkout.size.toString()
        totalTime.text = getTotalTime()

        backButton = findViewById(R.id.returnToNames)
        addRest = findViewById(R.id.addpause)
        editConfirmButton = findViewById(R.id.editConfirmButton)
        seconds = findViewById(R.id.createTime)
        list = findViewById(R.id.addExercisesList)
        list.adapter = WorkoutCreatorAdapter(ExerciseProvider.exercises, this)
    }

    private fun getTotalTime(): String {
        var totalWorkoutTime:Int = 0
        for(exercise in customWorkout){
            totalWorkoutTime += exercise.time
        }

        val minutes:Int = totalWorkoutTime / 60
        val secondsLeft:Int = totalWorkoutTime%60

        return "$minutes:$secondsLeft"
    }
}
