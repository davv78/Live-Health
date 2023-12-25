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

class CprActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cpr)

        val back_cpr: ImageButton = findViewById(R.id.back_cpr)
        back_cpr.setOnClickListener(this)

        val VideoCpr: VideoView = findViewById(R.id.video_cpr)
        VideoCpr.setVideoPath("android.resource://" + packageName + "/" + R.raw.cpr)
        VideoCpr.start()

        val mediaController = MediaController(this)
        mediaController.setAnchorView(VideoCpr)
        VideoCpr.setMediaController(mediaController)
    }

    override fun onClick(v: View?) {
        when (v?.id) {

            R.id.back_cpr -> {
                val backintent = Intent(this@CprActivity, CardNonEmergecnyActivity::class.java)
                startActivity(backintent)
            }
        }
    }
}