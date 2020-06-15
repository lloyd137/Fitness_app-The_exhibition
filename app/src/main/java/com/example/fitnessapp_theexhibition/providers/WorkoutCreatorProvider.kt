package com.example.fitnessapp_theexhibition.providers

import android.content.Context
import com.example.fitnessapp_theexhibition.models.Workout
import com.example.fitnessapp_theexhibition.models.WorkoutExercise
import com.google.gson.GsonBuilder

object WorkoutCreatorProvider {

    var currentExercisesList: ArrayList<WorkoutExercise> = ArrayList()
    var currentWorkout: Workout = Workout("", "", currentExercisesList)
    var exerciseDuration: Int = 30

    fun clearExercisesList() {
        currentExercisesList.clear()
    }

    fun clearWorkout() {
        currentExercisesList.clear()
        currentWorkout.name = ""
        currentWorkout.description = ""
    }

    fun writeToLocalStorage(workout: Workout, context:Context) {
        //Make JSON string with the use of library GSON
        val gsonPretty = GsonBuilder().setPrettyPrinting().create()

        val jsonString: String = gsonPretty.toJson(workout)
//        println("Pretty json: ")
//        println(jsonString)
//        try {
//            val fo = FileWriter("data/custom_workouts.json", true)
//            fo.write(jsonString)
//            fo.close()
//        } catch (ex:Exception){
//            print(ex.message)
//        }

        val sharedPref = context?.getSharedPreferences(
            "preferences", Context.MODE_PRIVATE)
//            ?: return with(sharedPref.edit())

    }
}