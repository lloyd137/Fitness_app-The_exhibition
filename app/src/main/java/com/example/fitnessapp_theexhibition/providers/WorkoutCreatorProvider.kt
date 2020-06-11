package com.example.fitnessapp_theexhibition.providers

import com.example.fitnessapp_theexhibition.models.Workout
import com.example.fitnessapp_theexhibition.models.WorkoutExercise

object WorkoutCreatorProvider {

    var currentExercisesList:ArrayList<WorkoutExercise> = ArrayList()
    var currentWorkout:Workout = Workout("", "", currentExercisesList)
    var exerciseDuration:Int = 30

    fun clearExercisesList(){
        currentExercisesList.clear()
    }

    fun clearWorkout(){
        currentExercisesList.clear()
        currentWorkout.name = ""
        currentWorkout.description = ""
    }
}