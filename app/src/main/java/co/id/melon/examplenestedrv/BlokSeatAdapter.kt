package co.id.melon.examplenestedrv

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.id.melon.examplenestedrv.databinding.ItemBlokSeatBinding
import com.davidecirillo.multichoicerecyclerview.MultiChoiceAdapter

class BlokSeatAdapter(
    private val context: Context?,
    private val blokModel: HashMap<String, HashMap<String, ArrayList<Long>>>
) : RecyclerView.Adapter<BlokSeatAdapter.ViewHolder>() {
    private var seatAdapters: SeatAdapter? = null
    private val rvPool = RecyclerView.RecycledViewPool()
    private var status:Status? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlokSeatAdapter.ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding: ItemBlokSeatBinding =
            DataBindingUtil.inflate(inflater, R.layout.item_blok_seat, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return blokModel.keys.size
    }

    override fun onBindViewHolder(holder: BlokSeatAdapter.ViewHolder, position: Int) {
        holder.bind(blokModel, position)
    }

    inner class ViewHolder(private val binding: ItemBlokSeatBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: HashMap<String, HashMap<String, ArrayList<Long>>>, position: Int) {
            val blokName = data.keys.elementAt(position)
            val getSeatChild = data.get(blokName)
            val status = Status()
            status.isSelected = false
            binding.txtBlokSeat.text = blokName
            seatAdapters = SeatAdapter(context, getSeatChild, status)
            binding.rvSeatMapper.apply {
                layoutManager = GridLayoutManager(context, 5)
                adapter = seatAdapters
                setRecycledViewPool(rvPool)
            }
        }
    }

}