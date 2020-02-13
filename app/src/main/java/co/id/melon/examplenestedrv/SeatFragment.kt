package co.id.melon.examplenestedrv

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import co.id.melon.examplenestedrv.databinding.FrameSeatBinding

class SeatFragment : DialogFragment(){
    private lateinit var binding: FrameSeatBinding
    private var adapter: BlokSeatAdapter? = null
    private var dataSeat: HashMap<String, HashMap<String, ArrayList<Long>>>? = null

    companion object{
        val DATA_SEAT = "seater"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.frame_seat, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        isCancelable = true
        val bundle = arguments
        dataSeat = bundle?.getSerializable(DATA_SEAT) as HashMap<String, HashMap<String, ArrayList<Long>>>
        Log.i("INFONYA CUY", "HASIL ${dataSeat?.keys}")
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = BlokSeatAdapter(context, dataSeat!!)
        binding.rvSeatFragment.layoutManager = LinearLayoutManager(context)
        binding.rvSeatFragment.adapter = adapter
        binding.btnDone.setOnClickListener {
            dismiss()
        }
    }

    override fun onResume() {
        val height = resources.getDimensionPixelSize(R.dimen.popup_height_seat)
        val width = resources.getDimensionPixelSize(R.dimen.popup_width_seat)
        dialog?.window?.setLayout(width, height)
        super.onResume()
    }

}