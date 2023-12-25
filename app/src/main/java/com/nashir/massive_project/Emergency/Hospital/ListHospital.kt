package com.nashir.massive_project.Emergency.Hospital

import HospitalAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nashir.massive_project.Emergency.EmergencyActivity
import com.nashir.massive_project.Emergency.Model.Hospital
import com.nashir.massive_project.R

class ListHospital : AppCompatActivity(), View.OnClickListener {

    private var hospitalList = ArrayList<Hospital>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_hospital)

        val backButton = findViewById<ImageButton>(R.id.back_rs)
        backButton.setOnClickListener(this)

        val recyclerView: RecyclerView = findViewById(R.id.rv_hospital)
        val adapter = HospitalAdapter(hospitalList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        initData()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.back_rs -> {
                val backIntent = Intent(this, EmergencyActivity::class.java)
                startActivity(backIntent)
            }
        }
    }

    private fun initData() {
        hospitalList.apply {
            add(Hospital("RS Simpangan Depok", "2 km", "081218109516"))
            add(Hospital("RSU Hasanah Graha Afiah", "5 km", "987654321"))
            add(Hospital("RS Citra Medika", "8 km", "111222333"))
            add(Hospital("RSUD Hermina Depok", "10 km", "444555666"))
            add(Hospital("RS Harapan Depok", "15 km", "777888999"))
            add(Hospital("RS Citra Medika", "20 km", "123123123"))
        }
    }
}
