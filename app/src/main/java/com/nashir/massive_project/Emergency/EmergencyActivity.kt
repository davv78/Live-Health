package com.nashir.massive_project.Emergency

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import com.nashir.massive_project.Emergency.customerService.CallCustomerServiceActivity
import com.nashir.massive_project.Emergency.Ambulance.ListAmbulanActivity
import com.nashir.massive_project.Emergency.Hospital.ListHospital
import com.nashir.massive_project.MenuActivity
import com.nashir.massive_project.R

class EmergencyActivity : AppCompatActivity(), View.OnClickListener {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emergency)

        val cs : ImageButton = findViewById(R.id.btncs)
        val ambulan : ImageButton = findViewById(R.id.btnambulan)
        val back : ImageButton = findViewById(R.id.back_Emergency)

        back.setOnClickListener(this)
        cs.setOnClickListener(this)
        ambulan.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when(v.id) {

                R.id.btncs -> {
                    val CSIntent = Intent(this@EmergencyActivity, ListHospital::class.java)
                    startActivity(CSIntent)
                }

                R.id.btnambulan -> {
                    val ambulanIntent = Intent(this@EmergencyActivity, ListAmbulanActivity::class.java)
                    startActivity(ambulanIntent)
                }

                R.id.back_Emergency -> {
                    val backIntent = Intent(this@EmergencyActivity, MenuActivity::class.java)
                    startActivity(backIntent)
                }

            }
        }
    }
}