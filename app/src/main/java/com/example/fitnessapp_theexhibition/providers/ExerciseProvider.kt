package com.example.fitnessapp_theexhibition.providers

import com.example.fitnessapp_theexhibition.models.Exercise

object ExerciseProvider {

    val exercises = ArrayList<Exercise>()

    //Add exercises to list
    fun generateExercises(){
        exercises.add(Exercise("Abdominal crunches", "Lie flat on your back your feet flat on the ground, with your knees bent at 90 degrees.", "Abs"))
        exercises.add(Exercise("Air squats", "Place your feet at shoulder width apart while keeping your chest up and your abdominals embraced, Begin the movement by swinging your arms up toward your shoulder, while also bending your knees till an angle of 90 degrees.", "Thigs, Abs & Calves"))
        exercises.add(Exercise("Bicycles crunches", "Lie on your back with your knees pointing toward your head. Move up with your arms behind your ears. bring your left arm to your right knee and your right arm to your left knee.", "Abs"))
        exercises.add(Exercise("Butt kicks", "Run in place while holding a tight core and flat back. Bring your heel as high up as possible, aiming for your butt.", "Glutes & Thighs"))
        exercises.add(Exercise("Push ups", "Get in a plank position and bend your arms down while holding them as close as possible to your sides. When your arms are around 90 degrees, move back till your arms are almost straight again and repeat.", "Chest & Triceps"))
        exercises.add(Exercise("Plank", "Lock yourself in the plank position ensuring that your body forms a straight line from shoulders to heels.", "Abs"))
    }

    fun addExercise(exercise: Exercise){
        exercises.add(exercise)
    }

    fun findExerciseByName(name:String):Exercise{
        for (exercise in exercises){
            if (exercise.name == name){
                return exercise
            }
        }
        return Exercise("Not found", "default", "-")
    }
}