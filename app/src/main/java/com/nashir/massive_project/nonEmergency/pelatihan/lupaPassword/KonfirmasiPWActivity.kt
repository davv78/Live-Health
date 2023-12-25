package com.nashir.massive_project.nonEmergency.pelatihan.lupaPassword

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.nashir.massive_project.NonEmergency.Pelatihan.Login.LoginActivity
import com.nashir.massive_project.R

class KonfirmasiPWActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_konfirmasi_pwactivity)

        val back_confirmpw : ImageButton = findViewById(R.id.back_confirmpw)
        back_confirmpw.setOnClickListener(this)

        val next3 : Button = findViewById(R.id.btn_next3)
        next3.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v != null){
            when(v.id){
                R.id.back_confirmpw -> {
                    val intent = Intent(this@KonfirmasiPWActivity, KodeVerifActivity::class.java)
                    startActivity(intent)
                }

                R.id.btn_next3 -> {
                    val intent = Intent(this@KonfirmasiPWActivity, LoginActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}