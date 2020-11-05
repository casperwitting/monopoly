package space.housableproperty

import space.property.Property

interface HousableProperty : Property {
//    val flatRent: Int
//    val oneHouseRent: Int
//    val twoHousesRent: Int
//    val threeHousesRent: Int
//    val fourHousesRent: Int
//    val hotelRent: Int
    val rentScheme: RentScheme
    val costOfHouse: Int
    var buildings: MutableList<Building>
}