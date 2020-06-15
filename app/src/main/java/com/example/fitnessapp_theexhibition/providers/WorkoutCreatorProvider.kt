package com.example.fitnessapp_theexhibition.providers

import android.content.Context
import com.example.fitnessapp_theexhibition.models.Workout
import com.example.fitnessapp_theexhibition.models.WorkoutExercise
import com.google.gson.GsonBuilder
import org.json.JSONArray

object WorkoutCreatorProvider {

    var customWorkouts:ArrayList<Workout> = ArrayList()
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

    fun getFromLocalStorage(context: Context){

        val preferences = context.getSharedPreferences("custom", Context.MODE_PRIVATE)
        val jsonString:String = preferences.getString("custom", "[]")
        val jsonArray = JSONArray(jsonString)

        println(jsonString)
        for (i in 0 until jsonArray.length()){
            val workout = jsonArray.getJSONObject(i)

            //Transform JSONObject into WorkoutExercise
            customWorkouts.add(Workout(workout))
        }
    }

    fun writeToLocalStorage(workout: Workout, context:Context) {
        //Make JSON string with the use of library GSON
        customWorkouts.add(workout)

        val gsonPretty = GsonBuilder().setPrettyPrinting().create()
        val jsonString: String = gsonPretty.toJson(customWorkouts)
        println(jsonString)
        val preferences = context.getSharedPreferences("custom", Context.MODE_PRIVATE)
        preferences.edit().putString("custom", jsonString).apply()
    }
}