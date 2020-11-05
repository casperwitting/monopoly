package space

import space.housableproperty.Hotel
import space.housableproperty.House
import space.housableproperty.HousableProperty
import space.property.Property
import space.property.RailRoad
import space.property.Utility

class RentCalculator {
    fun getRentPrice(property: Property, amountRolled: Int = 0): Int {
        if (property is HousableProperty) {
            if (property.buildings.filterIsInstance<Hotel>().count() > 0) {
                return property.rentScheme.hotelRent
            }

            when (property.buildings.filterIsInstance<House>().count()) {
                0 -> {
                    var ownsAllProperties = true
                    for (otherProperty : Property in property.group.properties) {
                        if (!otherProperty.isOwned() || otherProperty.owner != property.owner) {
                            ownsAllProperties = false
                        }
                    }

                    if (ownsAllProperties) {
                        return property.rentScheme.flatRent * 2
                    }

                    return property.rentScheme.flatRent
                }
                1 -> {
                    return property.rentScheme.oneHouseRent
                }
                2 -> {
                    return property.rentScheme.twoHousesRent
                }
                3 -> {
                    return property.rentScheme.threeHousesRent
                }
                4 -> {
                    return property.rentScheme.fourHousesRent
                }
            }
        }

        if (property is Utility) {
            when(property.group.properties.filter { it.isOwned() && it.owner == property.owner }.count()) {
                1 -> {
                    return 4 * amountRolled
                }
                2 -> {
                    return 10 * amountRolled
                }
                3 -> {
                    return 20 * amountRolled
                }
            }
        }

        if (property is RailRoad) {
            when(property.group.properties.filter { it.isOwned() && it.owner == property.owner }.count()) {
                1 -> {
                    return 25
                }
                2 -> {
                    return 50
                }
                3 -> {
                    return 100
                }
                4 -> {
                    return 200
                }
            }
        }

        return 0;
    }

}
