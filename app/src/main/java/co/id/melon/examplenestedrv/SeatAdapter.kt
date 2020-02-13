package co.id.melon.examplenestedrv

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import co.id.melon.examplenestedrv.databinding.ItemSeatBinding
import java.util.*
import kotlin.collections.ArrayList


class SeatAdapter(
    private val context: Context?,
    private val blokModel: HashMap<String, ArrayList<Long>>?,
    private val status: Status
) : RecyclerView.Adapter<SeatAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeatAdapter.ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding: ItemSeatBinding =
            DataBindingUtil.inflate(inflater, R.layout.item_seat, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return blokModel?.keys!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(blokModel,status, position)
    }

    inner class ViewHolder(private val binding: ItemSeatBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: HashMap<String, ArrayList<Long>>?, status: Status, position: Int) {
            val sorted: TreeMap<String, ArrayList<Long>> = TreeMap(data)
            val stringName = sorted.keys.elementAt(position)
            binding.textSeatNumber.text = stringName
            binding.root.setOnClickListener {
                !status.isSelected
                binding.root.setBackgroundColor(Color.BLUE)
                Toast.makeText(context, "HALO ${sorted.get(stringName)?.get(0)}", Toast.LENGTH_SHORT).show()
            }
        }
    }

//    fun getDataStatus(position: Int): ArrayList<Long>{
//        val list = ArrayList<Long>()
//        for (x in 0 until status.size){
//            if (!status.get(x).isSelected){
//                val keysnya = blokModel!!.keys.elementAt(position)
//                val value = blokModel.get(keysnya)!![0]
//                list.add(value)
//            }
//        }
//        return list
//    }
}