import java.util.*

fun main() {
    val parking = Parking()
    StubVehicles.listOfVehicles.forEach {
        parking.checkIn(it)
    }

    with(parking) {
        showParkedVehicles()
        checkout("BBB2222")
        checkout("EEE5555")
        checkout("ZZZ2626")
        showEarnings()
        showParkedVehicles()
    }

}

object StubVehicles {
    val listOfVehicles = listOf(
        Vehicle(plate = "AAA1111", type = VehicleType.CAR, discountCard = "DISCOUNT_CARD_001"),
        Vehicle(plate = "BBB2222", type = VehicleType.CAR, checkInTime = Calendar.getInstance().getTimeOnPast(120), discountCard = "DISCOUNT_CARD_002"),
        Vehicle(plate = "CCC3333", type = VehicleType.MINIBUS),
        Vehicle(plate = "DDD4444", type = VehicleType.BUS, discountCard = "DISCOUNT_CARD_002"),
        Vehicle(plate = "EEE5555", type = VehicleType.CAR),
        Vehicle(plate = "FFF6666", type = VehicleType.MOTORCYCLE),
        Vehicle(plate = "GGG7777", type = VehicleType.MINIBUS),
        Vehicle(plate = "HHH8888", type = VehicleType.BUS, discountCard = "DISCOUNT_CARD_004"),
        Vehicle(plate = "III9999", type = VehicleType.CAR, discountCard = "DISCOUNT_CARD_005"),
        Vehicle(plate = "JJJ1010", type = VehicleType.MOTORCYCLE),
        Vehicle(plate = "KKK1111", type = VehicleType.MINIBUS),
        Vehicle(plate = "LLL1212", type = VehicleType.BUS, discountCard = "DISCOUNT_CARD_006"),
        Vehicle(plate = "MMM1313", type = VehicleType.CAR, discountCard = "DISCOUNT_CARD_010"),
        Vehicle(plate = "NNN1414", type = VehicleType.MOTORCYCLE),
        Vehicle(plate = "OOO1515", type = VehicleType.MINIBUS),
        Vehicle(plate = "PPP1616", type = VehicleType.BUS, discountCard = "DISCOUNT_CARD_011"),
        Vehicle(plate = "QQQ1717", type = VehicleType.CAR, discountCard = "DISCOUNT_CARD_012"),
        Vehicle(plate = "RRR1818", type = VehicleType.MOTORCYCLE),
        Vehicle(plate = "SSS1919", type = VehicleType.MINIBUS),
        Vehicle(plate = "TTT2020", type = VehicleType.MOTORCYCLE),
        Vehicle(plate = "UUU2121", type = VehicleType.MOTORCYCLE),
        Vehicle(plate = "XXX2222", type = VehicleType.MOTORCYCLE, discountCard = "DISCOUNT_CARD_013")
    )
}