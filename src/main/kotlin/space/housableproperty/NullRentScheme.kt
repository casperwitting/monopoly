package space.housableproperty

data class NullRentScheme(
    override val flatRent: Int = 0,
    override val oneHouseRent: Int = 0,
    override val twoHousesRent: Int = 0,
    override val threeHousesRent: Int = 0,
    override val fourHousesRent: Int = 0,
    override val hotelRent: Int = 0
) : RentScheme