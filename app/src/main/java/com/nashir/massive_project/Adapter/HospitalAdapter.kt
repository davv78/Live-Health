import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.nashir.massive_project.Emergency.Model.Hospital
import com.nashir.massive_project.R

class HospitalAdapter(private val hospitalList: List<Hospital>) : RecyclerView.Adapter<HospitalAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val hospitalNameTextView: TextView = itemView.findViewById(R.id.hospitalNameTextView)
        val hospitalDistanceTextView: TextView = itemView.findViewById(R.id.hospitalDistanceTextView)
        val hospitalPhoneIcon: ImageView = itemView.findViewById(R.id.hospitalPhoneIcon)

        init {
            hospitalPhoneIcon.setOnClickListener {
                val hospital = hospitalList[adapterPosition]
                makePhoneCall(hospital.phoneNumber, itemView.context)
            }

            itemView.setOnClickListener {
                val hospital = hospitalList[adapterPosition]
                showCallConfirmationDialog(itemView.context, hospital.phoneNumber)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.hospital_card_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hospital = hospitalList[position]
        holder.hospitalNameTextView.text = hospital.name
        holder.hospitalDistanceTextView.text = hospital.distance
    }

    override fun getItemCount(): Int {
        return hospitalList.size
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
