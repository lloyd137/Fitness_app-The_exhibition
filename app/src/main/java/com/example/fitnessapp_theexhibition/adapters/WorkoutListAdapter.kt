package com.example.fitnessapp_theexhibition.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.fitnessapp_theexhibition.R
import com.example.fitnessapp_theexhibition.models.Workout

class WorkoutListAdapter(private val context: Context, private val dataSource: ArrayList<Workout>) : BaseAdapter(){

    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    //Workout list item variables
    private lateinit var title:TextView
    private lateinit var description:TextView

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        //Get item
        val item = inflater.inflate(R.layout.workout_list_item, parent, false)
        val workout:Workout = getItem(position) as Workout

        title = item.findViewById(R.id.workoutName)
        title.text = workout.name

        description = item.findViewById(R.id.workoutDescription)
        description.text = workout.description
        return item
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return dataSource.size
    }
}