package com.example.fitnessapp_theexhibition.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.fitnessapp_theexhibition.R
import com.example.fitnessapp_theexhibition.models.WorkoutExercise

class WorkoutExercisesAdapter(val exercises:ArrayList<WorkoutExercise>, val context: Context) : BaseAdapter() {

    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    private lateinit var title: TextView
    private lateinit var description: TextView
    private lateinit var muscleGroup: TextView
    private lateinit var time: TextView

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val item = inflater.inflate(R.layout.workout_exercise_list_item, parent, false)
        val exercise: WorkoutExercise = getItem(position) as WorkoutExercise

        title = item.findViewById(R.id.workoutExerciseName)
        description = item.findViewById(R.id.workoutExerciseDescription)
        muscleGroup = item.findViewById(R.id.workoutExerciseMuscleGroup)
        time = item.findViewById(R.id.workoutExerciseTime)

        title.text = exercise.exercise.name
        description.text = exercise.exercise.description
        muscleGroup.text = exercise.exercise.muscleGroup
        time.text = exercise.time.toString() + "Sec"

        return item
    }

    override fun getItem(position: Int): Any {
        return exercises[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return exercises.size
    }
}