package co.id.melon.examplenestedrv

import android.app.Activity
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AddTicketInvitationViewModel : ViewModel(){
    private val dataCategory: MutableLiveData<Invitation> = MutableLiveData()
    private val dummy = "{\n" +
            "    \"error\": 0,\n" +
            "    \"type\": \"Y\",\n" +
            "    \"category\": [\n" +
            "        {\n" +
            "            \"cat_ticket_id\": 2443,\n" +
            "            \"name\": \"SILVER - Free Seating\",\n" +
            "            \"seat_number\": 0,\n" +
            "            \"price\": {\"TUNAI\":1350000,\"CC BCA \":1170450,\"CC NON BCA \":1377000},\n" +
            "            \"available\": 18\n" +
            "        },\n" +
            "        {\n" +
            "            \"cat_ticket_id\": 2444,\n" +
            "            \"name\": \"GOLD - Free Seating\",\n" +
            "            \"seat_number\": 0,\n" +
            "            \"price\": {\"TUNAI\":1350000,\"CC BCA \":1170450,\"CC NON BCA \":1377000},\n" +
            "            \"available\": 150\n" +
            "        },\n" +
            "        {\n" +
            "            \"cat_ticket_id\": 2445,\n" +
            "            \"name\": \"PLATINUM - Round table numbered seating\",\n" +
            "            \"seat_number\": 1,\n" +
            "            \"price\": {\"TUNAI\":1350000,\"CC BCA \":1170450,\"CC NON BCA \":1377000},\n" +
            "            \"seat\": {\n" +
            "                \"MM\": {\n" +
            "                    \"3\": [\n" +
            "                        5013348\n" +
            "                    ],\n" +
            "                    \"4\": [\n" +
            "                        5013349\n" +
            "                    ],\n" +
            "                    \"5\": [\n" +
            "                        5013350\n" +
            "                    ],\n" +
            "                    \"6\": [\n" +
            "                        5013351\n" +
            "                    ],\n" +
            "                    \"7\": [\n" +
            "                        5013352\n" +
            "                    ],\n" +
            "                    \"8\": [\n" +
            "                        5013353\n" +
            "                    ],\n" +
            "                    \"9\": [\n" +
            "                        5013354\n" +
            "                    ],\n" +
            "                    \"10\": [\n" +
            "                        5013355\n" +
            "                    ],\n" +
            "                    \"11\": [\n" +
            "                        5013356\n" +
            "                    ],\n" +
            "                    \"12\": [\n" +
            "                        5013357\n" +
            "                    ],\n" +
            "                    \"13\": [\n" +
            "                        5013358\n" +
            "                    ],\n" +
            "                    \"14\": [\n" +
            "                        5013359\n" +
            "                    ],\n" +
            "                    \"15\": [\n" +
            "                        5013360\n" +
            "                    ],\n" +
            "                    \"16\": [\n" +
            "                        5013361\n" +
            "                    ],\n" +
            "                    \"17\": [\n" +
            "                        5013362\n" +
            "                    ],\n" +
            "                    \"18\": [\n" +
            "                        5013363\n" +
            "                    ],\n" +
            "                    \"19\": [\n" +
            "                        5013364\n" +
            "                    ],\n" +
            "                    \"20\": [\n" +
            "                        5013365\n" +
            "                    ]\n" +
            "                },\n" +
            "                \"NN\": {\n" +
            "                    \"1\": [\n" +
            "                        5013366\n" +
            "                    ],\n" +
            "                    \"2\": [\n" +
            "                        5013367\n" +
            "                    ],\n" +
            "                    \"3\": [\n" +
            "                        5013368\n" +
            "                    ],\n" +
            "                    \"4\": [\n" +
            "                        5013369\n" +
            "                    ],\n" +
            "                    \"5\": [\n" +
            "                        5013370\n" +
            "                    ],\n" +
            "                    \"6\": [\n" +
            "                        5013371\n" +
            "                    ],\n" +
            "                    \"7\": [\n" +
            "                        5013372\n" +
            "                    ],\n" +
            "                    \"8\": [\n" +
            "                        5013373\n" +
            "                    ],\n" +
            "                    \"9\": [\n" +
            "                        5013374\n" +
            "                    ],\n" +
            "                    \"10\": [\n" +
            "                        5013375\n" +
            "                    ]\n" +
            "                }\n" +
            "            }\n" +
            "        },\n" +
            "        {\n" +
            "            \"cat_ticket_id\": 2446,\n" +
            "            \"name\": \"DIAMOND - Front round table numbered seating\",\n" +
            "            \"seat_number\": 1,\n" +
            "            \"price\": {\"TUNAI\":1350000,\"CC BCA \":1170450,\"CC NON BCA \":1377000},\n" +
            "            \"seat\": {\n" +
            "                \"MM\": {\n" +
            "                    \"1\": [\n" +
            "                        5013376\n" +
            "                    ],\n" +
            "                    \"2\": [\n" +
            "                        5013377\n" +
            "                    ],\n" +
            "                    \"3\": [\n" +
            "                        5013378\n" +
            "                    ],\n" +
            "                    \"4\": [\n" +
            "                        5013379\n" +
            "                    ],\n" +
            "                    \"5\": [\n" +
            "                        5013380\n" +
            "                    ],\n" +
            "                    \"6\": [\n" +
            "                        5013381\n" +
            "                    ],\n" +
            "                    \"7\": [\n" +
            "                        5013382\n" +
            "                    ],\n" +
            "                    \"8\": [\n" +
            "                        5013383\n" +
            "                    ],\n" +
            "                    \"9\": [\n" +
            "                        5013384\n" +
            "                    ],\n" +
            "                    \"10\": [\n" +
            "                        5013385\n" +
            "                    ],\n" +
            "                    \"11\": [\n" +
            "                        5013386\n" +
            "                    ],\n" +
            "                    \"12\": [\n" +
            "                        5013387\n" +
            "                    ],\n" +
            "                    \"13\": [\n" +
            "                        5013388\n" +
            "                    ],\n" +
            "                    \"14\": [\n" +
            "                        5013389\n" +
            "                    ],\n" +
            "                    \"15\": [\n" +
            "                        5013390\n" +
            "                    ],\n" +
            "                    \"16\": [\n" +
            "                        5013391\n" +
            "                    ],\n" +
            "                    \"17\": [\n" +
            "                        5013392\n" +
            "                    ],\n" +
            "                    \"18\": [\n" +
            "                        5013393\n" +
            "                    ],\n" +
            "                    \"19\": [\n" +
            "                        5013394\n" +
            "                    ],\n" +
            "                    \"20\": [\n" +
            "                        5013395\n" +
            "                    ],\n" +
            "                    \"21\": [\n" +
            "                        5013396\n" +
            "                    ],\n" +
            "                    \"22\": [\n" +
            "                        5013397\n" +
            "                    ],\n" +
            "                    \"23\": [\n" +
            "                        5013398\n" +
            "                    ],\n" +
            "                    \"24\": [\n" +
            "                        5013399\n" +
            "                    ],\n" +
            "                    \"25\": [\n" +
            "                        5013400\n" +
            "                    ],\n" +
            "                    \"26\": [\n" +
            "                        5013401\n" +
            "                    ],\n" +
            "                    \"27\": [\n" +
            "                        5013402\n" +
            "                    ],\n" +
            "                    \"28\": [\n" +
            "                        5013403\n" +
            "                    ],\n" +
            "                    \"29\": [\n" +
            "                        5013404\n" +
            "                    ],\n" +
            "                    \"30\": [\n" +
            "                        5013405\n" +
            "                    ],\n" +
            "                    \"31\": [\n" +
            "                        5013406\n" +
            "                    ],\n" +
            "                    \"32\": [\n" +
            "                        5013407\n" +
            "                    ],\n" +
            "                    \"33\": [\n" +
            "                        5013408\n" +
            "                    ],\n" +
            "                    \"34\": [\n" +
            "                        5013409\n" +
            "                    ],\n" +
            "                    \"35\": [\n" +
            "                        5013410\n" +
            "                    ],\n" +
            "                    \"36\": [\n" +
            "                        5013411\n" +
            "                    ],\n" +
            "                    \"37\": [\n" +
            "                        5013412\n" +
            "                    ],\n" +
            "                    \"38\": [\n" +
            "                        5013413\n" +
            "                    ],\n" +
            "                    \"39\": [\n" +
            "                        5013414\n" +
            "                    ],\n" +
            "                    \"40\": [\n" +
            "                        5013415\n" +
            "                    ]\n" +
            "                }\n" +
            "            }\n" +
            "        }\n" +
            "    ]\n" +
            "}"

    fun sendReq(activity: Activity?){
        val params: HashMap<String, String?> = hashMapOf(
            "user_id" to "1"
        )
        val header: Map<String, String> = mapOf(
            "authorization" to "3cb5e15b91b2409c438b67f2cfa3eac410f215ea"
        )
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                try {
//                    val response = OkHttpHelper.executePost(Config.URL_CHECK_DATA_SALES, params, header)
                    val gson = Gson()
                    val categoryMapper = gson.fromJson(dummy, Invitation::class.java)
                    dataCategory.postValue(categoryMapper)
                }catch (e: Exception){
                    e.printStackTrace()
                }
            }
        }
    }


    fun getData(): LiveData<Invitation> = dataCategory

}