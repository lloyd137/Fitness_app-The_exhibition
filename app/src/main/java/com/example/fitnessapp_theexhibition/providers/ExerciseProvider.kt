package com.example.fitnessapp_theexhibition.providers

import com.example.fitnessapp_theexhibition.models.Exercise

object ExerciseProvider {

    val exercises = ArrayList<Exercise>()

    fun addExercise(exercise: Exercise){
        exercises.add(exercise)
    }
}