package com.example.fitnessapp_theexhibition.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.fitnessapp_theexhibition.R
import com.example.fitnessapp_theexhibition.models.Exercise

class ExerciseAdapter(private val context: Context, private var exercises: ArrayList<Exercise>) :
    BaseAdapter() {

    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    private lateinit var title: TextView
    private lateinit var description: TextView
    private lateinit var muscleGroup: TextView

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val item = inflater.inflate(R.layout.exercise_list_item, parent, false)
        val exercise:Exercise = getItem(position) as Exercise

        title = item.findViewById(R.id.exerciseName)
        title.text = exercise.name

        description = item.findViewById(R.id.exerciseDescription)
        description.text = exercise.description

        muscleGroup = item.findViewById(R.id.exerciseMuscleGroup)
        muscleGroup.text = exercise.muscle_group

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