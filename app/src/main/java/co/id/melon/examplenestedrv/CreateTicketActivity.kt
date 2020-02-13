package co.id.melon.examplenestedrv

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import co.id.melon.examplenestedrv.databinding.ActivityCreateTicketBinding
import java.io.Serializable


class CreateTicketActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityCreateTicketBinding
    private var seatMapp: Serializable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_create_ticket)

        binding.btnSeat.setOnClickListener(this)

        val bundle = intent.extras
        seatMapp = bundle!!.getSerializable(MainActivity.SEAT)

    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btn_seat -> {
                goToSeat(seatMapp)
            }
        }
    }

    private fun goToSeat(serializable: Serializable?){
        val bundle = intent.extras
        val fragment = SeatFragment()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        bundle?.putSerializable(SeatFragment.DATA_SEAT, serializable )
        fragment.arguments = bundle
        fragment.show(fragmentTransaction, SeatFragment.DATA_SEAT)
    }
}
