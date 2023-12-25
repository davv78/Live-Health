package com.nashir.massive_project.nonEmergency.tutorial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.MediaController
import android.widget.VideoView
import com.nashir.massive_project.nonEmergency.CardNonEmergecnyActivity
import com.nashir.massive_project.R

class SakitKepalaActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sakit_kepala)

        val back: ImageButton = findViewById(R.id.back7)
        back.setOnClickListener(this)

        val Video_Sakit_Kepala: VideoView = findViewById(R.id.video_sakit_kepala)
        Video_Sakit_Kepala.setVideoPath("android.resource://" + packageName + "/" + R.raw.sakit_kepala)
        Video_Sakit_Kepala.start()

        val mediaController = MediaController(this)
        mediaController.setAnchorView(Video_Sakit_Kepala)
        Video_Sakit_Kepala.setMediaController(mediaController)
    }

    override fun onClick(v: View?) {

        when (v?.id) {

            R.id.back7 -> {
                val backintent = Intent(this@SakitKepalaActivity, CardNonEmergecnyActivity::class.java)
                startActivity(backintent)
            }
        }
    }
}