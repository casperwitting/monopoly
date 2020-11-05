package space

import board.Building

interface HousableProperty : Property {
    val flatRent: Int
    val oneHouseRent: Int
    val twoHousesRent: Int
    val threeHousesRent: Int
    val fourHousesRent: Int
    val hotelRent: Int
    val costOfHouse: Int
    var buildings: MutableList<Building>
}