package com.example.fitnessapp_theexhibition.providers

import com.example.fitnessapp_theexhibition.models.Workout

object WorkoutProvider {

    private val workouts = ArrayList<Workout>()

    fun addWorkout(workout: Workout){
        workouts.add(workout)
    }


}