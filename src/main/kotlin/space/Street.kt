package space

import board.Building
import board.Hotel
import board.House
import player.Player

class Street(
    override var description: String,
    override var price: Int,
    override val flatRent: Int,
    override val oneHouseRent: Int,
    override val twoHousesRent: Int,
    override val threeHousesRent: Int,
    override val fourHousesRent: Int,
    override val hotelRent: Int,
    override val costOfHouse: Int,
    val mortgageValue: Int
) : HousableProperty {
    override lateinit var owner: Player
    override var buildings = mutableListOf<Building>()
    override lateinit var group: PropertyGroup

    override fun isOwned(): Boolean {
        return this::owner.isInitialized
    }

    fun addBuilding(building: Building) {
        if (buildings.filterIsInstance<House>().count() >= 4) {
            throw AddBuildingException("Cannot add more than four houses to a street.")
        }

        if (buildings.filterIsInstance<Hotel>().count() >= 1) {
            throw AddBuildingException("Cannot add more than one hotel to a street.")
        }

        buildings.add(building)
    }
}