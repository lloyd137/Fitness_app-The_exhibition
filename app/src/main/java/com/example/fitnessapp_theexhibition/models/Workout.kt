package com.example.fitnessapp_theexhibition.models

import org.json.JSONArray
import org.json.JSONObject

data class Workout(
    var name: String,
    var description: String,
    val exercises: ArrayList<WorkoutExercise>
) {
    constructor(json: JSONObject) : this(
        json.getString("name"),
        json.getString("description"),
        getExercisesFromJSON(json)
    )
}

private fun getExercisesFromJSON(json: JSONObject): ArrayList<WorkoutExercise> {
    val jsonExercises: ArrayList<WorkoutExercise> = ArrayList()

    val jsonArray:JSONArray = json.getJSONArray("workout_exercises")
    for (i in 0 until jsonArray.length()){
        val exercise = jsonArray.getJSONObject(i)

        //Transform JSONObject into WorkoutExercise
        jsonExercises.add(WorkoutExercise(exercise))
    }

    return jsonExercises
}

