package com.example.fitnessapp_theexhibition.models

import org.json.JSONObject

data class Exercise(var name:String, var description:String, var muscle_group:String) {
    constructor(jsonObject: JSONObject) : this(
        "" + jsonObject.getString("name"),
        "" + jsonObject.getString("description"),
        "" + jsonObject.getString("muscle_group")
    )
}