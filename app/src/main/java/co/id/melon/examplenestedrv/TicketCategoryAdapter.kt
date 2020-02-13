package co.id.melon.examplenestedrv

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import co.id.melon.examplenestedrv.databinding.ItemTicketCategoryBinding
import java.text.NumberFormat
import java.util.*

class TicketCategoryAdapter(private val context: Context?,
                            private val data: Invitation): RecyclerView.Adapter<TicketCategoryAdapter.ViewHolder>(){

    private var onItem:onItemCallBack?= null

    fun setClickCallback(onitemCallBack: onItemCallBack){
        this.onItem = onitemCallBack
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TicketCategoryAdapter.ViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val itemTicket: ItemTicketCategoryBinding = DataBindingUtil.inflate(inflater, R.layout.item_ticket_category, parent, false)
        return ViewHolder(itemTicket, onItem)
    }

    override fun getItemCount(): Int {
        return data.category!!.size
    }

    override fun onBindViewHolder(holder: TicketCategoryAdapter.ViewHolder, position: Int) {
        holder.bind(data, position)
        holder.itemView.setOnClickListener{onItem?.onItem(data.category!!.get(holder.adapterPosition), position)}
    }

    inner class ViewHolder(private val binding: ItemTicketCategoryBinding,
                           private val onItemCall: onItemCallBack?): RecyclerView.ViewHolder(binding.root){

        fun bind(data: Invitation, position: Int){
            val name = data.category!![position].nameTicket
            val localId = Locale("in", "ID")
            val available = data.category!![position].ticketAvailable
            if (!data.category!![position].price?.keys!!.isNullOrEmpty()){
                val methodPrice = data.category!![position].price?.keys!!.elementAt(0)
                val price = data.category!![position].price?.get(methodPrice)
                binding.txtHargaTicket.text = NumberFormat.getCurrencyInstance(localId).format(price)
            }else{
                binding.txtHargaTicket.text = "-"
            }
            binding.txtTicketCategory.text = name
            if (data.category!![position].seatNumber!!.equals(1)){
                binding.txtAvailable.text = context?.resources?.getString(R.string.seat_available)
            }else{
                binding.txtAvailable.text = available.toString()
            }
        }
    }

    interface onItemCallBack{
        fun onItem(data: DetailCategory, position: Int)
    }
}