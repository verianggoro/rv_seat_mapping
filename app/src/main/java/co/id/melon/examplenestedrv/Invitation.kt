package co.id.melon.examplenestedrv

import com.google.gson.annotations.SerializedName

data class Invitation(
    @SerializedName("error") var error: Int? = 0,
    @SerializedName("type") var type: String? = null,
    @SerializedName("category") var category: ArrayList<DetailCategory>? = null
)

data class DetailCategory(
    @SerializedName("cat_ticket_id") var idTickect: Long? = 0,
    @SerializedName("name") var nameTicket: String? = null,
    @SerializedName("seat_number") var seatNumber: Int? = 0,
    @SerializedName("available") var ticketAvailable: Int? = 0,
    @SerializedName("price") var price: HashMap<String, Int>? = null,
    @SerializedName("seat") var seat: HashMap<String, HashMap<String, ArrayList<Long>>>? = null
)

class Status{
    var isSelected: Boolean = false
}

data class Ticket(
    var error: Int? = 0,
    var type: String? = null,
    var category: ArrayList<DetailTicket>? = null
)

data class DetailTicket(
    var idTicket: Long? = 0,
    var nameTicket: String? = null,
    var seatNumber: Int? = 0,
    var ticketAvailable: Int? = 0,
    var seat: HashMap<String, HashMap<String, ArrayList<Long>>>? = null
)