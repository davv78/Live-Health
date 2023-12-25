package com.nashir.massive_project.NonEmergency.Pelatihan.model

 data class PelatihanModel (

    val id: Int,
    val namaPelatihan: String,
    val lokasiPelatihan: String,
    val status: String,
    val tanggalMulai: String,
    val tanggalSelesai: String,
    val lembagaPelatihan: String,
    val instruktur: String,
    val kategori: String,
    val tingkatanMateri: String,
    val batasUsia: Int,
    val jadwalPertemuan: String
)

