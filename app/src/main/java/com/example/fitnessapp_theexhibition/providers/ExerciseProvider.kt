package com.example.fitnessapp_theexhibition.providers

import android.content.Context
import com.example.fitnessapp_theexhibition.models.Exercise
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream

object ExerciseProvider {

    val exercises = ArrayList<Exercise>()

    //Add exercises to list
    fun generateExercises(context: Context) {

        exercises.clear()
        val jsonString:String = getExercisesFromJSON(context)
        val jsonObject: JSONObject = JSONObject(jsonString)
        val jsonArray:JSONArray = jsonObject.getJSONArray("exercises")
        for (i in 0 until jsonArray.length()){
            val exercise = jsonArray.getJSONObject(i)

            println("Number of the array: $i")
            println(exercise.toString())
            //Transform JSONObject into WorkoutExercise
            exercises.add(Exercise(exercise))
        }
    }

    private fun getExercisesFromJSON(context: Context): String {
        var jsonString: String = ""
        var inputStream: InputStream? = null

        try {
            //Create inputStream
            inputStream = context.assets.open("exercises.json")
            val size = inputStream.available()

            //Create buffer with the size
            val buffer = ByteArray(size)

            //Read data from inputStream into the buffer
            inputStream.read(buffer)

            //Create a json string
            jsonString = String(buffer)
            return jsonString
        } catch (ioException: IOException) {
            ioException.printStackTrace()
        } finally {
            inputStream?.close()
        }
        return jsonString
    }

    fun addExercise(exercise: Exercise) {
        exercises.add(exercise)
    }

    fun findExerciseByName(name: String): Exercise {
        for (exercise in exercises) {
            if (exercise.name == name) {
                return exercise
            }
        }
        return Exercise("Not found", "default", "-")
    }


}