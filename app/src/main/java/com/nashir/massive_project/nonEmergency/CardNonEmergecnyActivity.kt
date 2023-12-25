package com.nashir.massive_project.nonEmergency

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.cardview.widget.CardView
import com.nashir.massive_project.R
import com.nashir.massive_project.nonEmergency.tutorial.TenggelamActivity
import com.nashir.massive_project.nonEmergency.tutorial.AsmaActivity
import com.nashir.massive_project.nonEmergency.tutorial.CprActivity
import com.nashir.massive_project.nonEmergency.tutorial.KecelakanActivity
import com.nashir.massive_project.nonEmergency.tutorial.LukaActivity
import com.nashir.massive_project.nonEmergency.tutorial.PendarahanActivity
import com.nashir.massive_project.nonEmergency.tutorial.SakitKepalaActivity
import com.nashir.massive_project.nonEmergency.tutorial.SeranganJantungActivity

class CardNonEmergecnyActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_non_emergecny)

        val exit: ImageButton = findViewById(R.id.back_materi)
        exit.setOnClickListener(this)

        val cpr: CardView = findViewById(R.id.cardView2)
        cpr.setOnClickListener(this)

        val asma: CardView = findViewById(R.id.cardView)
        asma.setOnClickListener(this)

        val kecelakaan: CardView = findViewById(R.id.cardView3)
        kecelakaan.setOnClickListener(this)

        val jantung: CardView = findViewById(R.id.cardView4)
        jantung.setOnClickListener(this)

        val tenggelam: CardView = findViewById(R.id.cardView5)
        tenggelam.setOnClickListener(this)

        val sakit_kepala: CardView = findViewById(R.id.cardView6)
        sakit_kepala.setOnClickListener(this)

        val pendarahan: CardView = findViewById(R.id.cardView7)
        pendarahan.setOnClickListener(this)

        val luka_bakar: CardView = findViewById(R.id.cardView8)
        luka_bakar.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v?.id) {

                R.id.back_materi -> {
                    val backintent = Intent(this@CardNonEmergecnyActivity, NonEmergencyActivity::class.java)
                    startActivity(backintent)
                }

                R.id.cardView -> {
                    val asmaintent = Intent(this@CardNonEmergecnyActivity, CprActivity::class.java)
                    startActivity(asmaintent)
                }

                R.id.cardView2 -> {
                    val cprintent = Intent(this@CardNonEmergecnyActivity, AsmaActivity::class.java)
                    startActivity(cprintent)
                }

                R.id.cardView3 -> {
                    val kecelakaanintent =
                        Intent(this@CardNonEmergecnyActivity, KecelakanActivity::class.java)
                    startActivity(kecelakaanintent)
                }

                R.id.cardView4 -> {
                    val jantungintent =
                        Intent(this@CardNonEmergecnyActivity, SeranganJantungActivity::class.java)
                    startActivity(jantungintent)
                }
//
                R.id.cardView5 -> {
                    val tenggelamintent =
                        Intent(this@CardNonEmergecnyActivity, TenggelamActivity::class.java)
                    startActivity(tenggelamintent)
                }

                R.id.cardView6 -> {
                    val kepalaintent =
                        Intent(this@CardNonEmergecnyActivity, SakitKepalaActivity::class.java)
                    startActivity(kepalaintent)
                }

                R.id.cardView7 -> {
                    val pendarahanintent =
                        Intent(this@CardNonEmergecnyActivity, PendarahanActivity::class.java)
                    startActivity(pendarahanintent)
                }

                R.id.cardView8 -> {
                    val lukaintent = Intent(this@CardNonEmergecnyActivity, LukaActivity::class.java)
                    startActivity(lukaintent)
//            }
                }
            }
        }
    }
}