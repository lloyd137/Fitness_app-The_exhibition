package com.example.fitnessapp_theexhibition.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import com.example.fitnessapp_theexhibition.R
import com.example.fitnessapp_theexhibition.models.WorkoutExercise
import com.example.fitnessapp_theexhibition.providers.WorkoutProvider

class WorkoutExecutionActivity : AppCompatActivity() {

    lateinit var timer: CountDownTimer
    lateinit var exerciseTitle: TextView
    lateinit var timerTextView: TextView

    var exerciseDone: Boolean = true
    var hasRunIntro:Boolean = false
    var exerciseNumber: Int = -1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout_execution)
        this.title = intent.getStringExtra("workoutName")
        timerTextView = findViewById(R.id.workoutTimer)
        exerciseTitle = findViewById(R.id.exerciseTitle)

         //Start with a 5 second countdown
            introTimer()

    }

    private fun exercisePhase(){
        println("Entered the exercise phase")
        //Walk through list of exercises

            if (exerciseDone) {
                exerciseNumber++
                println("upped exerciseNumber")
                println("Exercise number = $exerciseNumber, exercise list size is ${WorkoutProvider.findWorkoutByName(title.toString()).exercises.size}")
                if (exerciseNumber == WorkoutProvider.findWorkoutByName(title.toString()).exercises.size) {
                    //Workout finished!
                    finish()
                } else {
                    var exercise: WorkoutExercise =
                        WorkoutProvider.findWorkoutByName(title.toString()).exercises[exerciseNumber]
                    exerciseTimer(exercise)
                }
            }


            //Close screen if all exercises are done.


    }

    private fun introTimer() {
        exerciseTitle.text = "The workout will start in..."
        timer = object : CountDownTimer(5000, 1000) {

            override fun onFinish() {
                hasRunIntro =true
                exercisePhase()
            }

            override fun onTick(millisUntilFinished: Long) {
                timerTextView.text = (millisUntilFinished / 1000 + 1).toInt().toString() + " seconds"
            }
        }
        timer.start()
    }

    private fun exerciseTimer(exercise: WorkoutExercise) {
        exerciseDone = false
        println("exerciseDone set to false")
        exerciseTitle.text = "${exercise.exercise.name}"
        println("exerciseTitle set to ${exercise.exercise.name}")
        timer = object : CountDownTimer(3000, 1000) {
            override fun onFinish() {
                exerciseDone = true
                println("exerciseDone set to true")
                exercisePhase()
            }

            override fun onTick(millisUntilFinished: Long) {
                timerTextView.text = (millisUntilFinished / 1000 + 1).toInt().toString() + " seconds"
                println((millisUntilFinished / 1000 + 1).toInt().toString() + " seconds")
            }

        }
        timer.start()
        println("timer has started")
    }
}
