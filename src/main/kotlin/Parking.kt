import Constants.MAX_PARKED_VEHICLES

data class Parking(val vehicles: MutableSet<Vehicle> = mutableSetOf()) {

    private var vehiclesToEarnings = Pair(0,0)

    private fun addVehicle(vehicle: Vehicle) :Boolean  = vehicles.size < MAX_PARKED_VEHICLES && vehicles.add(vehicle)

    fun checkIn(vehicle: Vehicle) {
        if (addVehicle(vehicle)) {
            println("Welcome to AlkeParking!")
        } else {
            println("Sorry, the check-in failed.")
        }
    }

    fun checkout(plate: String) {
        val vehicle = vehicles.firstOrNull { it.plate == plate }
        vehicle?.let {
            vehicles.remove(vehicle)
            val parkingSpace = ParkingSpace(it, ::onSuccess, ::onError)
            val fee = parkingSpace.checkOutVehicle(it)
            vehiclesToEarnings = Pair(vehiclesToEarnings.first + 1, vehiclesToEarnings.second + fee)
        } ?: onError()

    }

    private fun onSuccess(fee: Int) {
        println("Your fee is $fee Come back soon.")
    }

    private fun onError() {
        println("Sorry, the checkout failed.")
    }

    fun showEarnings() {
        println("${vehiclesToEarnings.first} vehicles have checked out and have earnings of $${vehiclesToEarnings.second}.")
    }

    fun showParkedVehicles() {
        var parkedVehiclesPlates = ""
        vehicles.forEachIndexed { index, vehicle ->
            parkedVehiclesPlates += vehicle.plate

            if (index < vehicles.size - 1) {
                parkedVehiclesPlates  += ", "
            }
        }

        println("Parked vehicles: $parkedVehiclesPlates")
    }
}
