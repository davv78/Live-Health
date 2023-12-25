package com.nashir.massive_project.nonEmergency.pelatihan.lupaPassword

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.nashir.massive_project.R

class LupaPwActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lupa_pw)

        val btn_next1: TextView = findViewById(R.id.btn_next1)
        btn_next1.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.btn_next1 -> {
                    val intent = Intent(this@LupaPwActivity, KodeVerifActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}