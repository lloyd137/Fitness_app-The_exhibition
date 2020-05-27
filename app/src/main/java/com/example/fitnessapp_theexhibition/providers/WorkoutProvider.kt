package com.example.fitnessapp_theexhibition.providers

import com.example.fitnessapp_theexhibition.models.Workout

object WorkoutProvider {

    val workouts = ArrayList<Workout>()

    fun addWorkout(workout: Workout){
        workouts.add(workout)
    }




}