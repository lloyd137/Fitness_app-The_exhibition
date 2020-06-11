package com.example.fitnessapp_theexhibition.adapters

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.NumberPicker
import android.widget.TextView
import com.example.fitnessapp_theexhibition.R
import com.example.fitnessapp_theexhibition.models.WorkoutExercise
import com.example.fitnessapp_theexhibition.providers.WorkoutCreatorProvider

class EditWorkoutAdapter(val exercises: ArrayList<WorkoutExercise>, val context: Context) :
    BaseAdapter() {

    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    private lateinit var title: TextView
    private lateinit var description: TextView
    private lateinit var muscleGroup: TextView
    private lateinit var time: TextView
    private lateinit var deleteButton: Button
    private lateinit var editButton: Button

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val item = inflater.inflate(R.layout.edit_workout_item, parent, false)
        val exercise: WorkoutExercise = getItem(position) as WorkoutExercise

        title = item.findViewById(R.id.exerciseName3)
        description = item.findViewById(R.id.exerciseDescription3)
        muscleGroup = item.findViewById(R.id.exerciseMuscleGroup3)
        time = item.findViewById(R.id.workoutExerciseTime2)
        deleteButton = item.findViewById(R.id.deleteExerciseButton)
        editButton = item.findViewById(R.id.editExerciseButton)

        title.text = exercise.exercise.name
        description.text = exercise.exercise.description
        muscleGroup.text = exercise.exercise.muscleGroup
        time.text = exercise.time.toString() + "Sec"

        deleteButton.setOnClickListener {
            //Delete from provider
            WorkoutCreatorProvider.currentExercisesList.remove(exercise)

            //Delete from list view
            exercises.remove(exercise)
            notifyDataSetChanged()
        }

        editButton.setOnClickListener {
            buildDialog(exercise, position)
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

    private fun buildDialog(exercise: WorkoutExercise, position: Int){
        val builder = Dialog(context)

        builder.setTitle("Edit exercise")
        builder.setContentView(R.layout.dialog_input);
        val b1 = builder.findViewById<Button>(R.id.button1);
        val b2 = builder.findViewById<Button>(R.id.button2);
        val numberPicker:NumberPicker = builder.findViewById(R.id.numberPicker1);

        numberPicker.value = exercise.time
        numberPicker.maxValue = 500;
        numberPicker.minValue = 1;
        numberPicker.wrapSelectorWheel = false;
        numberPicker.setOnValueChangedListener { picker, oldVal, newVal ->

        }
        b1.setOnClickListener{
            //Save changes
            exercise.time = numberPicker.value
            WorkoutCreatorProvider.currentExercisesList[position].time = exercise.time
            time.text = exercise.time.toString() + "Sec"
            builder.dismiss()
            notifyDataSetChanged()
        }

        b2.setOnClickListener {
            builder.dismiss()
        }

        builder.show()
    }

}