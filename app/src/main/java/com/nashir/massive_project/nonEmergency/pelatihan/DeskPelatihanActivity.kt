package com.nashir.massive_project.nonEmergency.pelatihan

import PelatihanModel
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.nashir.massive_project.R
import com.nashir.massive_project.nonEmergency.pelatihan.sertifikat.ClaimSertifikatActivity

class DeskPelatihanActivity : AppCompatActivity(){

    private var listPelatihan: List<PelatihanModel> = createDummyPelatihanData() // Menambahkan inisialisasi data
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_desk_pelatihan)


        val pelatihanId = intent.getIntExtra("pelatihan_id", -1)
        val pelatihan = getPelatihanDetail(pelatihanId)

        val btnDownload = findViewById<Button>(R.id.download_sertifikat)
        btnDownload.setOnClickListener {
            val intent = Intent(this@DeskPelatihanActivity, ClaimSertifikatActivity::class.java)
            startActivity(intent)
        }

        val backDesk = findViewById<ImageButton>(R.id.back_deskpelatihan)

        backDesk.setOnClickListener {
                val backIntent = Intent(this@DeskPelatihanActivity, PelatihanActivity::class.java)
                startActivity(backIntent)
        }
        // Mendapatkan referensi button daftar
        val buttonDaftar = findViewById<Button>(R.id.daftar_pelatihan)

        buttonDaftar.setOnClickListener {
            // Menampilkan dialog konfirmasi
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Konfirmasi Pendaftaran")
            builder.setMessage("Apakah Anda ingin mendaftar pada pelatihan ini?")

            // Tombol "Ya"
            builder.setPositiveButton("Ya") { _, _ ->
                // Menampilkan pesan bahwa data sudah dikirim
                val dataSentDialog = AlertDialog.Builder(this)
                dataSentDialog.setTitle("Data Terkirim")
                dataSentDialog.setMessage("Data sudah dikirim.")
                dataSentDialog.setPositiveButton("OK") { _, _ ->
                    // Aksi setelah tombol OK ditekan
                }
                dataSentDialog.show()
            }

            // Tombol "Batal"
            builder.setNegativeButton("Batal") { dialog, _ ->
                dialog.dismiss() // Menutup dialog
            }

            val dialog = builder.create()
            dialog.show() // Menampilkan dialog konfirmasi
        }

        val imgPelatihan: ImageView = findViewById(R.id.gambar_desk)
        val tvJudul: TextView = findViewById(R.id.title_desk)
        val tvLokasi: TextView = findViewById(R.id.desk_location)
        val tvStatus: TextView = findViewById(R.id.status_desk)
        val tvTanggalMulai: TextView = findViewById(R.id.start_date_desk)
        val tvTanggalSelesai: TextView = findViewById(R.id.end_date_desk)
        val tvKategori: TextView = findViewById(R.id.kategory_desk)
        val tvTingkatan: TextView = findViewById(R.id.chapter_desk)
        val tvMedia: TextView = findViewById(R.id.media_desk)
        val tvAge: TextView = findViewById(R.id.age_range_desk)

        pelatihan?.let { imgPelatihan.setImageResource(it.gambar) }
        tvJudul.text = pelatihan?.judul
        tvLokasi.text = pelatihan?.lokasi
        tvStatus.text = pelatihan?.status
        tvKategori.text = pelatihan?.kategori
        tvTanggalMulai.text = pelatihan?.tanggalMulai
        tvTanggalSelesai.text = pelatihan?.tanggalSelesai
        tvTingkatan.text = pelatihan?.tingkatMateri
        tvMedia.text = pelatihan?.mediaAjar
        tvAge.text = pelatihan?.usia


        // Tampilkan atribut-atribut pelatihan lainnya di sini
    }

    private fun getPelatihanDetail(pelatihanId: Int): PelatihanModel? {
        // Iterasi melalui daftar pelatihan untuk mencari yang sesuai dengan ID
        for (pelatihan in listPelatihan) {
            if (pelatihan.id == pelatihanId) {
                return pelatihan
            }
        }
        return null // Mengembalikan null jika tidak ditemukan pelatihan dengan ID yang sesuai
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
