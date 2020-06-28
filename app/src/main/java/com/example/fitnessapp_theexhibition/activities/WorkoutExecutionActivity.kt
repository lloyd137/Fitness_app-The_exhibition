package com.example.fitnessapp_theexhibition.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.VideoView
import com.example.fitnessapp_theexhibition.R
import com.example.fitnessapp_theexhibition.models.WorkoutExercise
import com.example.fitnessapp_theexhibition.providers.WorkoutProvider

class WorkoutExecutionActivity : AppCompatActivity() {

    lateinit var timer: CountDownTimer
    lateinit var exerciseTitle: TextView
    lateinit var timerTextView: TextView
    lateinit var video: VideoView
    lateinit var image: ImageView
    lateinit var videoText: TextView

    var exerciseDone: Boolean = true
    var hasRunIntro: Boolean = false
    var exerciseNumber: Int = -1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout_execution)
        this.title = intent.getStringExtra("workoutName")
        timerTextView = findViewById(R.id.workoutTimer)
        exerciseTitle = findViewById(R.id.exerciseTitle)
        video = findViewById(R.id.exerciseVideo)
        video.visibility = View.INVISIBLE
        image = findViewById(R.id.exerciseImage)
        videoText = findViewById(R.id.videoText)

        //Start with a 5 second countdown
        introTimer()

    }

    private fun exercisePhase() {
        //Walk through list of exercises
        if (exerciseDone) {
            exerciseNumber++

            if (exerciseNumber == WorkoutProvider.findWorkoutByName(title.toString()).workout_exercises.size) {
                //Workout finished!
                val intent: Intent = Intent(this, WorkoutFinishedActivity::class.java).apply {
                    putExtra("workoutName", intent.getStringExtra("workoutName"))
                }
                startActivity(intent)
                finish()
            } else {
                //Close screen if all exercises are done.
                var exercise: WorkoutExercise =
                    WorkoutProvider.findWorkoutByName(title.toString()).workout_exercises[exerciseNumber]
                exerciseTimer(exercise)
            }
        }
    }

    private fun introTimer() {
        exerciseTitle.text = "The workout will start in..."
        timer = object : CountDownTimer(5000, 1000) {

            override fun onFinish() {
                hasRunIntro = true
                exercisePhase()
            }

            override fun onTick(millisUntilFinished: Long) {
                timerTextView.text =
                    (millisUntilFinished / 1000 + 1).toInt().toString() + " seconds"
            }
        }
        timer.start()
    }

    private fun exerciseTimer(exercise: WorkoutExercise) {
        exerciseDone = false
        exerciseTitle.text = "${exercise.exercise.name}"
        getExerciseExample(exercise.exercise.name)
        timer = object : CountDownTimer(exercise.time.toLong() * 1000, 1000) {
            override fun onFinish() {
                exerciseDone = true
                exercisePhase()
            }

            override fun onTick(millisUntilFinished: Long) {
                timerTextView.text =
                    (millisUntilFinished / 1000 + 1).toInt().toString() + " seconds"
            }
        }
        timer.start()
    }

    private fun getExerciseExample(exercise: String) {
        //Check if you need to get image or video
        if (exercise == "Left side plank" || exercise == "Right side plank" || exercise == "Plank" || exercise == "Wall sit") {
            //Make video view invisible
            video.visibility = View.INVISIBLE
            image.visibility = View.VISIBLE

            //Set the image
            when (exercise) {
                "Left side plank" -> {
                    image.setImageResource(R.drawable.dekke_bear_left_side_plank)
                }
                "Right side plank" -> {
                    image.setImageResource(R.drawable.dekke_bear_right_side_plank)
                }
                "Plank" -> {
                    image.setImageResource(R.drawable.dekke_bear_plank)
                }
                "Wall sit" -> {
                    image.setImageResource(R.drawable.dekke_bear_wall_sit)
                }
            }

        } else {
            //Make imageview invisible
            video.visibility = View.VISIBLE
            image.visibility = View.INVISIBLE

            //Set the video
            when (exercise) {
                "Crunches" -> {
                    video.setVideoPath("android.resource://$packageName/${R.raw.dekke_bear_crunch}")
                }
                "Push-ups" -> {
                    video.setVideoPath("android.resource://$packageName/${R.raw.dekke_bear_push_up}")
                }
                "Pull-ups" -> {
                    video.setVideoPath("android.resource://$packageName/${R.raw.dekke_bear_pul_up}")
                }
                "Squats" -> {
                    video.setVideoPath("android.resource://$packageName/${R.raw.dekke_bear_squat}")
                }
                "Lunges" -> {
                    video.setVideoPath("android.resource://$packageName/${R.raw.dekke_bear_lunge}")
                }
                "Flutter kicks" -> {
                    video.setVideoPath("android.resource://$packageName/${R.raw.dekke_bear_flutter_kicks}")
                }
                "Superman" -> {
                    video.setVideoPath("android.resource://$packageName/${R.raw.dekke_bear_superman}")
                }
                "Bicycle crunch" -> {
                    video.setVideoPath("android.resource://$packageName/${R.raw.dekke_bear_bicycle_crunch}")
                }
                "Toe touches" -> {
                    video.setVideoPath("android.resource://$packageName/${R.raw.dekke_bear_toe_touch}")
                }
                "Reverse crunch" -> {
                    video.setVideoPath("android.resource://$packageName/${R.raw.dekke_bear_reverse_crunch}")
                }
                "Leg raises" -> {
                    video.setVideoPath("android.resource://$packageName/${R.raw.dekke_bear_leg_raise}")
                }
            }

            video.start()

            video.setOnPreparedListener {
                it.setVolume(0.toFloat(),0.toFloat())
                it.isLooping = true
            }

            //Set text
            videoText.text = exercise + " example"
        }
    }
}
