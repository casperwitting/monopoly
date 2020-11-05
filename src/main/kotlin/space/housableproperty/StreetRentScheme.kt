package space.housableproperty

data class StreetRentScheme(
    override val flatRent: Int,
    override val oneHouseRent: Int,
    override val twoHousesRent: Int,
    override val threeHousesRent: Int,
    override val fourHousesRent: Int,
    override val hotelRent: Int
) : RentScheme {
}