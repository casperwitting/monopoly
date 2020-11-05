package board

import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test
import player.Player
import space.housableproperty.*

class StreetTest {
    private lateinit var street: Street

    @Before
    fun setUp() {
        street = Street(
            "dorpsstraat",
            price = 60,
            costOfHouse = 50,
            mortgageValue = 30,
            rentScheme = StreetRentScheme(
                flatRent = 2,
                oneHouseRent = 10,
                twoHousesRent = 30,
                threeHousesRent = 90,
                fourHousesRent = 160,
                hotelRent = 250
            )
        )
    }

    @Test
    fun testChangeStreetOwner() {
        val player = Player("John Doe")
        street.owner = player

        assertEquals(player, street.owner)
    }

    @Test
    fun testAddGetHouse() {
        val house = House()
        street.addBuilding(house)

        assertEquals(house, street.buildings.first())
    }

    @Test(expected = AddBuildingException::class)
    fun testWhenAddingMoreThanFourBuildingsThenThrowException() {
        street.addBuilding(House())
        street.addBuilding(House())
        street.addBuilding(House())
        street.addBuilding(House())
        street.addBuilding(House())
    }

    @Test(expected = AddBuildingException::class)
    fun testWhenAddingMoreThanOnceHotelThenThrowException() {
        street.addBuilding(Hotel())
        street.addBuilding(Hotel())
    }
}