package com.example.fitnessapp_theexhibition.providers

import com.example.fitnessapp_theexhibition.models.Workout

object WorkoutProvider {

    val workouts = ArrayList<Workout>()

    fun addWorkout(workout: Workout) {
        workouts.add(workout)
    }

    fun findWorkoutByName(name: String): Workout {
        for (workout in workouts) {
            if (workout.name == name) {
                return workout
            }
        }
        println("Found nothing")
        return Workout("Not found", "default", ArrayList())
    }

    fun findWorkoutById(id: Int): Workout {
        return if (workouts[id] == null) {
            println("Found nothing")
            Workout("Not found", "default", ArrayList())
        } else {
            workouts[id]
        }
    }
}