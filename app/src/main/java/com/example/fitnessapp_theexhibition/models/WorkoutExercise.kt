package com.example.fitnessapp_theexhibition.models

import org.json.JSONObject

data class WorkoutExercise(val exercise: Exercise, var time: Int){
    constructor(jsonObject: JSONObject) : this(
        Exercise(jsonObject.getJSONObject("exercise")),
        jsonObject.getInt("time")
    )

}