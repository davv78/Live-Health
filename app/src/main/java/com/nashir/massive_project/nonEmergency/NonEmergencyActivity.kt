package com.nashir.massive_project.nonEmergency


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.nashir.massive_project.MenuActivity
import com.nashir.massive_project.NonEmergency.Pelatihan.Login.LoginActivity
import com.nashir.massive_project.R

class NonEmergencyActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_non_emergency)

        val back : ImageButton = findViewById(R.id.back_nonEmergency)
        back.setOnClickListener(this)

        val materi : ImageButton = findViewById(R.id.btnmateri)
        materi.setOnClickListener(this)

        val pelatihan : ImageButton = findViewById(R.id.btn_pelatihan)
        pelatihan.setOnClickListener(this)



    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.btnmateri -> {
                    val materiintent = Intent(this@NonEmergencyActivity, CardNonEmergecnyActivity::class.java)
                    startActivity(materiintent)
                }

                R.id.back_nonEmergency -> {
                    val backIntent = Intent(this@NonEmergencyActivity, MenuActivity::class.java)
                    startActivity(backIntent)
                }

                R.id.btn_pelatihan -> {
                    val pelatihanIntent = Intent(this@NonEmergencyActivity, LoginActivity::class.java)
                    startActivity(pelatihanIntent)
                }
            }
        }
    }
}