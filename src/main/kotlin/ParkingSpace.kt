import Constants.FEE_DISCOUNT
import Constants.INTERVAL_FEE
import Constants.INTERVAL_FEE_IN_MINUTES
import Constants.MINUTES_IN_MILLISECONDS
import Constants.MINIMUM_FEE_TIME_IN_MINUTES
import java.util.Calendar

data class ParkingSpace(
    val vehicle: Vehicle,
    val onSuccess: (totalValue: Int) -> Unit,
    val onError: () -> Unit
) {

    private fun calculateParkedTime(vehicle: Vehicle): Long {
        return (Calendar.getInstance().timeInMillis - vehicle.checkInTime.timeInMillis) / MINUTES_IN_MILLISECONDS
    }

    fun checkOutVehicle(vehicle: Vehicle): Int {
        val fee = calculateFee(vehicle)
        onSuccess(fee)
        return fee
    }

    private fun calculateFee(vehicle: Vehicle) :Int {
        val parkedTime = calculateParkedTime(vehicle)
        print("You have stayed for $parkedTime minutes. ")

        var fee = vehicle.type.price

        if (parkedTime >= MINIMUM_FEE_TIME_IN_MINUTES) {
            val time = parkedTime - MINIMUM_FEE_TIME_IN_MINUTES
            val slots = kotlin.math.ceil(time / INTERVAL_FEE_IN_MINUTES).toInt()
            fee += slots * INTERVAL_FEE
        }

        vehicle.discountCard?.let {
            fee = calculateDiscount(fee)
        }

        return fee
    }

    private fun calculateDiscount(fee: Int) = (fee * (1 - FEE_DISCOUNT)).toInt()

}
