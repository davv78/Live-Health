package com.nashir.massive_project.nonEmergency.pelatihan.lupaPassword

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import com.nashir.massive_project.R

class KodeVerifActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kode_verif)

        val backverif : ImageButton = findViewById(R.id.back_verif)
        backverif.setOnClickListener(this)

        val nextverif : Button = findViewById(R.id.btn_next2)
        nextverif.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v != null) {
          when (v.id) {
              R.id.back_verif -> {
                  val intent = Intent (this@KodeVerifActivity, LupaPwActivity::class.java)
                  startActivity(intent)
              }

              R.id.btn_next2 -> {
                  val intent = Intent (this@KodeVerifActivity, KonfirmasiPWActivity::class.java)
                  startActivity(intent)
              }
          }
        }
    }
}