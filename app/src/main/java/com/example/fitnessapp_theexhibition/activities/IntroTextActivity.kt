package com.example.fitnessapp_theexhibition.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.fitnessapp_theexhibition.R

class IntroTextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(R.anim.fadein, R.anim.fadeout)
        setContentView(R.layout.activity_intro_text)

        val screen: ConstraintLayout = findViewById(R.id.screen)

        screen.setOnClickListener {
            val intent: Intent = Intent(this, IntroAnimationActivity::class.java)
            startActivity(intent)
        }
    }
}
