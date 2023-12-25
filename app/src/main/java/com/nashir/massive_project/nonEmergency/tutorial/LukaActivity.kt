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

class LukaActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_luka)

        val back: ImageButton = findViewById(R.id.bacK9)
        back.setOnClickListener(this)

        val VideoLuka: VideoView = findViewById(R.id.video_luka_bakar)
        VideoLuka.setVideoPath("android.resource://" + packageName + "/" + R.raw.luka_bakar)
        VideoLuka.start()

        val mediaController = MediaController(this)
        mediaController.setAnchorView(VideoLuka)
        VideoLuka.setMediaController(mediaController)
    }

    override fun onClick(V: View?) {
        when (V?.id) {

            R.id.bacK9 -> {
                val backintent = Intent(this@LukaActivity, CardNonEmergecnyActivity::class.java)
                startActivity(backintent)
            }
        }
    }
}