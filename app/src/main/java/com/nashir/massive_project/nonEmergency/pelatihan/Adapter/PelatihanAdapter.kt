package com.nashir.massive_project.nonEmergency.pelatihan.Adapter

import PelatihanModel
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nashir.massive_project.R
import com.nashir.massive_project.nonEmergency.pelatihan.DeskPelatihanActivity

// PelatihanAdapter.kt
class PelatihanAdapter(
    private val listPelatihan: List<PelatihanModel>,
    private val listener: (PelatihanModel) -> Unit
) : RecyclerView.Adapter<PelatihanAdapter.PelatihanViewHolder>() {

    inner class PelatihanViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imgPelatihan: ImageView = itemView.findViewById(R.id.card_img_pelatihan)
        private val tvTitle: TextView = itemView.findViewById(R.id.tv_pelatihan_title)
        private val tvStatus: TextView = itemView.findViewById(R.id.status_pelatihan)
        private val tvTanggalMulai: TextView = itemView.findViewById(R.id.date_start)
        private val tvTanggalSelesai: TextView = itemView.findViewById(R.id.date_end)

        init {
            itemView.setOnClickListener {
                val pelatihan = listPelatihan[adapterPosition]
                listener(pelatihan)
            }
        }

        fun bind(pelatihan: PelatihanModel) {
            imgPelatihan.setImageResource(pelatihan.gambar)
            tvTitle.text = pelatihan.judul
            tvStatus.text = pelatihan.status
            tvTanggalMulai.text = pelatihan.tanggalMulai
            tvTanggalSelesai.text = pelatihan.tanggalSelesai
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PelatihanViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.pelatihan_card_item, parent, false)
        return PelatihanViewHolder(view)
    }

    override fun onBindViewHolder(holder: PelatihanViewHolder, position: Int) {
        val pelatihan = listPelatihan[position]
        holder.bind(pelatihan)

        // Ketika item diklik, panggil fungsi listener
        holder.itemView.setOnClickListener {
            listener(pelatihan)
        }
    }


    override fun getItemCount(): Int {
        return listPelatihan.size
    }
}
class PelatihanConfirmationListener(val context: Context) {
    fun onConfirmation(pelatihan: PelatihanModel) {
        tampilkanDetailPelatihan(context, pelatihan)
    }

    private fun tampilkanDetailPelatihan(context: Context, pelatihan: PelatihanModel) {
        val intent = Intent(context, DeskPelatihanActivity::class.java)
        intent.putExtra("pelatihan_id", pelatihan.id)
        context.startActivity(intent)
    }

}



private fun showConfirmationDialog(context: Context, pelatihan: PelatihanModel) {
    val builder = AlertDialog.Builder(context)
    builder.setTitle("Konfirmasi Pelatihan")
    builder.setMessage("Anda tertarik dengan pelatihan ini?")
    builder.setPositiveButton("Ya") { dialog, _ ->
        val confirmationListener = PelatihanConfirmationListener(context)
        confirmationListener.onConfirmation(pelatihan)
        dialog.dismiss()
    }
    builder.setNegativeButton("Tidak") { dialog, _ ->
        dialog.dismiss()
    }
    val dialog = builder.create()
    dialog.show()
}

