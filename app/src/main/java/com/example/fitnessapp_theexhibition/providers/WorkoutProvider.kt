package com.example.fitnessapp_theexhibition.providers

import android.content.Context
import com.example.fitnessapp_theexhibition.models.Workout
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream

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

    fun generateWorkouts(context: Context) {
        workouts.clear()
        val jsonString:String = getWorkoutsFromJSON(context)
        val jsonObject: JSONObject = JSONObject(jsonString)
        val jsonArray: JSONArray = jsonObject.getJSONArray("workouts")
        for (i in 0 until jsonArray.length()){
            val workout = jsonArray.getJSONObject(i)

            //Transform JSONObject into WorkoutExercise
            workouts.add(Workout(workout))
        }

        WorkoutCreatorProvider.getFromLocalStorage(context)
        workouts.addAll(WorkoutCreatorProvider.customWorkouts)
    }

    private fun getWorkoutsFromJSON(context: Context): String {
        var jsonString: String = ""
        var inputStream: InputStream? = null

        try {
            //Create inputStream
            inputStream = context.assets.open("workouts.json")
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
}