package co.id.melon.examplenestedrv

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import co.id.melon.examplenestedrv.databinding.ActivityTicketInvitationBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityTicketInvitationBinding
    private lateinit var viewModel: AddTicketInvitationViewModel
    private lateinit var adapater: TicketCategoryAdapter
    companion object{
        val NAME = "TICKET_NAME"
        val SEAT_STATUS = "SEAT_STATUS"
        val SEAT = "SEAT"
        val PRICE_METHOD = "PRICE_METHOD"
        val PRICE_LIST = "PRICE_LIST"
        val ID_TICKET = "ID_TICKET"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_ticket_invitation)
        viewModel = ViewModelProvider(this).get(AddTicketInvitationViewModel::class.java)

        intial()
        attachData()
    }

    override fun onClick(p0: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun intial(){
        viewModel.sendReq(this)
        binding.barTicketInvitation.visibility = View.VISIBLE
        binding.rvTicketCategory.visibility = View.GONE
        binding.rvTicketCategory.layoutManager = LinearLayoutManager(this)
        binding.rvTicketCategory.isNestedScrollingEnabled = true

    }

    private fun attachData(){
        viewModel.getData().observe(this, Observer {invitation ->
            binding.barTicketInvitation.visibility = View.GONE
            adapater = TicketCategoryAdapter(this, invitation)
            adapater.setClickCallback(object : TicketCategoryAdapter.onItemCallBack{
                override fun onItem(data: DetailCategory, position:Int) {
                    val bundle = Bundle()
                    val methodPayment = invitation.category!![position].price!!.keys
                    val price = invitation.category!![position].price!!.values
                    val listPayment = ArrayList<String>()
                    val priceList = ArrayList<Int>()
                    val nameTicket = invitation.category!![position].nameTicket
                    val statusSeat = invitation.category!![position].seatNumber
                    val idTicket = invitation.category!![position].idTickect
                    val seat = invitation.category!![position].seat

                    Log.i("INFO MASTER", "MASTER $seat")
                    listPayment.addAll(methodPayment)
                    priceList.addAll(price)
                    bundle.putLong(ID_TICKET, idTicket!!)
                    bundle.putString(NAME, nameTicket)
                    bundle.putInt(SEAT_STATUS, statusSeat!!)
                    bundle.putStringArrayList(PRICE_METHOD, listPayment)
                    bundle.putIntegerArrayList(PRICE_LIST, priceList)
                    bundle.putSerializable(SEAT, seat)
                    val intent = Intent(applicationContext, CreateTicketActivity::class.java)
                    intent.putExtras(bundle)
                    startActivity(intent)
                }
            })
            binding.rvTicketCategory.adapter = adapater
            binding.rvTicketCategory.visibility = View.VISIBLE
        })
    }
}
