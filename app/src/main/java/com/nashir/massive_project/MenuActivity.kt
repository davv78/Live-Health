package com.nashir.massive_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import com.nashir.massive_project.Emergency.EmergencyActivity
import com.nashir.massive_project.nonEmergency.NonEmergencyActivity

class MenuActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val back_menu : ImageView = findViewById(R.id.back_menu)
        back_menu.setOnClickListener(this)

        val btnnonemergency : ImageButton = findViewById(R.id.btnnonemergency)
        btnnonemergency.setOnClickListener(this)

        val btnemergency : ImageButton = findViewById(R.id.btnemergency)
        btnemergency.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        if (v != null) {
            when (v.id) {

                R.id.back_menu -> {
                    val intent = Intent(this@MenuActivity, MainActivity::class.java)
                    startActivity(intent)
                }

                R.id.btnnonemergency -> {
                    val intent = Intent(this@MenuActivity, NonEmergencyActivity::class.java)
                    startActivity(intent)
                }

                R.id.btnemergency -> {
                    val intent = Intent(this@MenuActivity, EmergencyActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}