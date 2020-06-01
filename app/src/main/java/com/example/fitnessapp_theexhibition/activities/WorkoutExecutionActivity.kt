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

    var workoutRunning:Boolean = true
    var introTimerHasRun:Boolean = false
    var exerciseDone:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout_execution)
        this.title = intent.getStringExtra("workoutName")
        timerTextView = findViewById(R.id.workoutTimer)
        exerciseTitle = findViewById(R.id.exerciseTitle)

        while (workoutRunning) {

            if (!introTimerHasRun) {
                //Start with a 5 second countdown
                introTimer()
            }

            if (introTimerHasRun) {
                //Walk through list of exercises
                while (workoutRunning) {
                    var exerciseNumber: Int = -1
                    if (exerciseDone) {
                        exerciseNumber++
                    }

                    //Close screen if all exercises are done.
                    if (exerciseNumber == WorkoutProvider.findWorkoutByName(title.toString()).exercises.size)
                    {
                        //Workout finished!
                        finish()
                    }
                }
            }
        }
    }

    private fun introTimer() {
        exerciseTitle.text = "The workout will start in..."
        timer = object : CountDownTimer(5000, 1000) {

            override fun onFinish() {
                introTimerHasRun = true
            }

            override fun onTick(millisUntilFinished: Long) {
                timerTextView.text = (millisUntilFinished / 1000 + 1).toInt().toString() + "seconds"
            }
        }
        timer.start()
    }
}
