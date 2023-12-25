import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nashir.massive_project.Emergency.Model.Ambulance
import com.nashir.massive_project.R

class AmbulanceAdapter(private val ambulanceList: List<Ambulance>) : RecyclerView.Adapter<AmbulanceAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val distanceTextView: TextView = itemView.findViewById(R.id.distanceTextView)
        val phoneIcon: ImageView = itemView.findViewById(R.id.phoneIcon)

        init {
            phoneIcon.setOnClickListener {
                val ambulance = ambulanceList[adapterPosition]
                makePhoneCall(ambulance.phoneNumber, itemView.context)
            }

            itemView.setOnClickListener {
                val ambulance = ambulanceList[adapterPosition]
                showCallConfirmationDialog(itemView.context, ambulance.phoneNumber)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ambulance_card_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ambulance = ambulanceList[position]
        holder.nameTextView.text = ambulance.name
        holder.distanceTextView.text = ambulance.distance
    }

    override fun getItemCount(): Int {
        return ambulanceList.size
    }

    private fun makePhoneCall(phoneNumber: String, context: Context) {
        val dialIntent = Intent(Intent.ACTION_DIAL)
        dialIntent.data = Uri.parse("tel:$phoneNumber")
        context.startActivity(dialIntent)
    }

    private fun showCallConfirmationDialog(context: Context, phoneNumber: String) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Konfirmasi Panggilan")
        builder.setMessage("Untuk melakukan panggilan, maka akan dikenakan biaya. Apakah Anda ingin melakukan panggilan?")
        builder.setPositiveButton("Panggil") { dialog, _ ->
            makePhoneCall(phoneNumber, context)
            dialog.dismiss()
        }
        builder.setNegativeButton("Batal") { dialog, _ ->
            dialog.dismiss()
        }
        val dialog = builder.create()
        dialog.show()
    }
}
