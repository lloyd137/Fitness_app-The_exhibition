package com.example.fitnessapp_theexhibition.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.fitnessapp_theexhibition.R
import com.example.fitnessapp_theexhibition.activities.creator.CreateExercisesListActivity
import com.example.fitnessapp_theexhibition.models.Exercise
import com.example.fitnessapp_theexhibition.models.WorkoutExercise
import com.example.fitnessapp_theexhibition.providers.WorkoutCreatorProvider

class WorkoutCreatorAdapter (val exercises:ArrayList<Exercise>, val context: Context) : BaseAdapter() {

    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    private lateinit var title: TextView
    private lateinit var description: TextView
    private lateinit var muscleGroup: TextView
    private lateinit var addButton: Button

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val item = inflater.inflate(R.layout.add_exercise_item, parent, false)
        val exercise: Exercise = getItem(position) as Exercise

        title = item.findViewById(R.id.exerciseName2)
        description = item.findViewById(R.id.exerciseDescription2)
        muscleGroup = item.findViewById(R.id.exerciseMuscleGroup2)
        addButton = item.findViewById(R.id.addExerciseButton)

        title.text = exercise.name
        description.text = exercise.description
        muscleGroup.text = exercise.muscle_group

        addButton.setOnClickListener {
            //Exercise add
                if (WorkoutCreatorProvider.exerciseDuration.toString() == "") {
                    //Scenario one: Empty time field
                    Toast.makeText(
                        context,
                        context.getString(R.string.empty_time),
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    //Scenario two: add exercise with put in time
                    WorkoutCreatorProvider.currentExercisesList.add(
                        WorkoutExercise(
                            exercise,
                            WorkoutCreatorProvider.exerciseDuration
                        )
                    )

                    //Update fields in parent
                    (context as CreateExercisesListActivity).updateData()
                }
        }

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