package com.nashir.massive_project.nonEmergency.pelatihan.sertifikat

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.nashir.massive_project.R
import com.nashir.massive_project.nonEmergency.pelatihan.PelatihanActivity
import java.io.FileOutputStream

class ClaimSertifikatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_claim_sertifikat)

        val imgSertifikat = findViewById<ImageView>(R.id.image_sertifikat)
        val btnDownload = findViewById<Button>(R.id.download_file)
        val btnKembali = findViewById<ImageButton>(R.id.back_claimsertif)

        imgSertifikat.setImageResource(R.drawable.sertifikat)
        btnDownload.setOnClickListener {
            val imageResId = R.drawable.sertifikat
            imgSertifikat.setImageResource(imageResId)

            // Simpan gambar ke penyimpanan internal
            val bitmap = BitmapFactory.decodeResource(resources, imageResId)
            val fileOutputStream: FileOutputStream
            try {
                fileOutputStream = openFileOutput("nama_gambar.png", Context.MODE_PRIVATE)
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream)
                fileOutputStream.close()

                // Tampilkan pesan bahwa gambar telah disimpan
                val savedMessage = "Gambar sertifikat telah disimpan di perangkat."
                displayMessage(savedMessage)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }


        btnKembali.setOnClickListener {
            val intent = Intent(this@ClaimSertifikatActivity, PelatihanActivity::class.java)
            startActivity(intent)
        }
    }

    private fun displayMessage(message: String) {
        val builder = AlertDialog.Builder(this@ClaimSertifikatActivity)
        builder.setTitle("Penyimpanan Gambar")
        builder.setMessage(message)

        builder.setPositiveButton("OK") { _, _ ->
            // Aksi setelah tombol OK ditekan
        }

        val dialog = builder.create()
        dialog.show()
    }
}
