package com.nashir.massive_project.Emergency.Ambulance

import AmbulanceAdapter
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nashir.massive_project.Emergency.EmergencyActivity
import com.nashir.massive_project.Emergency.Model.Ambulance
import com.nashir.massive_project.R

class ListAmbulanActivity : AppCompatActivity(), View.OnClickListener {
    private var ambulanceList = ArrayList<Ambulance>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_ambulan)

        initData()

        val backButton = findViewById<ImageButton>(R.id.back_ambulan)
        val recyclerView: RecyclerView = findViewById(R.id.rv_ambulance)
        val adapter = AmbulanceAdapter(ambulanceList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        backButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.back_ambulan -> {
                val backIntent = Intent(this@ListAmbulanActivity, EmergencyActivity::class.java)
                startActivity(backIntent)
            }
        }
    }

    private fun initData() {
        ambulanceList.apply {
            add(Ambulance("RS Simpangan Depok", "2 km", "081218109516"))
            add(Ambulance("RSU Hasanah Graha Afiah", "5 km", "987654321"))
            add(Ambulance("RS Citra Medika", "8 km", "111222333"))
            add(Ambulance("RSUD Hermina Depok", "10 km", "444555666"))
            add(Ambulance("RS Harapan Depok", "15 km", "777888999"))
            add(Ambulance("RS Citra Medika", "20 km", "123123123"))
        }
    }
}



