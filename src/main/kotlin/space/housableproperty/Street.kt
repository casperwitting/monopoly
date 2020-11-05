package space.housableproperty

import player.Player
import space.property.PropertyGroup

class Street(
    override var description: String,
    override var price: Int,
    override val costOfHouse: Int,
    val mortgageValue: Int,
    override val rentScheme: RentScheme = NullRentScheme()
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