package com.nashir.massive_project.nonEmergency.pelatihan

import PelatihanModel
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nashir.massive_project.R
import com.nashir.massive_project.nonEmergency.NonEmergencyActivity
import com.nashir.massive_project.nonEmergency.pelatihan.Adapter.PelatihanAdapter

class PelatihanActivity : AppCompatActivity() {

    private lateinit var listPelatihan: List<PelatihanModel>
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pelatihan)

        listPelatihan = createDummyPelatihanData()

        recyclerView = findViewById(R.id.recyclerView_pelatihan)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = PelatihanAdapter(listPelatihan) { pelatihan ->
            val intent = Intent(this, DeskPelatihanActivity::class.java)
            intent.putExtra("pelatihan_id", pelatihan.id)
            startActivity(intent)
        }

        recyclerView.adapter = adapter

        val backpelatihan: ImageButton = findViewById(R.id.back_pelatihan)
        backpelatihan.setOnClickListener {
            val backIntent = Intent(this@PelatihanActivity, NonEmergencyActivity::class.java)
            startActivity(backIntent)
        }
    }




    private fun createDummyPelatihanData(): List<PelatihanModel> {
        return listOf(
            PelatihanModel(
                1,
                R.drawable.ppgd1,
                "Pelatihan Pertolongan Pertama Gawat Darurat",
                "Jl. Contoh No. 123, Kota Contoh",
                "Offline",
                "20 Nov 2023 07:48 WIB",
                "23 Nov 2023 07:00 WIB",
                "Medic",
                "Pemula",
                "Webinar",
                "18-40 Tahun"
            ),
            PelatihanModel(
                2,
                R.drawable.ppgd2,
                "Pelatihan Pertolongan Pertama Gawat Darurat",
                "Jl. Contoh No. 123, Kota Contoh",
                "Offline",
                "20 Des 2023 09:00 WIB",
                "25 Des 2023 12:00 WIB",
                "Emergency",
                "Menengah",
                "Kursus",
                "25-50 Tahun"
            ),
            PelatihanModel(
                3,
                R.drawable.ppgd3,
                "Pelatihan Pertolongan Pertama Gawat Darurat",
                "Jl. Contoh No. 123, Kota Contoh",
                "Offline",
                "10 Jan 2024 08:00 WIB",
                "15 Jan 2024 10:00 WIB",
                "Medic",
                "Lanjutan",
                "Webinar",
                "20-60 Tahun"
            ),
            PelatihanModel(
                4,
                R.drawable.ppgd4,
                "Pelatihan Pertolongan Pertama Gawat Darurat",
                "Jl. Contoh No. 123, Kota Contoh",
                "Offline",
                "05 Feb 2024 10:00 WIB",
                "10 Feb 2024 12:00 WIB",
                "Emergency",
                "Pemula",
                "Kursus",
                "30-55 Tahun"
            ),
            PelatihanModel(
                5,
                R.drawable.ppgd5,
                "Pelatihan Pertolongan Pertama Gawat Darurat",
                "Jl. Contoh No. 123, Kota Contoh",
                "Offline",
                "15 Mar 2024 09:00 WIB",
                "20 Mar 2024 11:00 WIB",
                "Emergency",
                "Menengah",
                "Webinar",
                "25-45 Tahun"
            ),
            PelatihanModel(
                6,
                R.drawable.ppgd6,
                "Pelatihan Pertolongan Pertama Gawat Darurat",
                "Jl. Contoh No. 123, Kota Contoh",
                "Offline",
                "25 Apr 2024 07:00 WIB",
                "30 Apr 2024 09:00 WIB",
                "Kursus",
                "Pemula",
                "Absen",
                "20-50 Tahun"
            )
        )
    }

}
