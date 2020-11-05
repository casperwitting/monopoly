package board

import space.property.Group
import space.housableproperty.Street
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test
import player.Player
import space.RentCalculator
import space.housableproperty.Hotel
import space.housableproperty.House
import space.housableproperty.StreetRentScheme

class StreetRentCalculatorTest {
    private lateinit var rentCalculator : RentCalculator
    private lateinit var street: Street

    @Before
    fun setUp() {
        rentCalculator = RentCalculator()
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
    fun testWhenStreetDoesNotHaveAnyHousesAndPlayerDoesNotOwnAllPropertiesThenRentIsFPrice() {
        val street2 = Street("1", 0, 0, 0)
        val group = Group()
        val player = Player()
        street.owner = player
        group.addProperty(street)
        group.addProperty(street2)
        assertEquals(2, rentCalculator.getRentPrice(street))
    }

    @Test
    fun testWhenPlayerOwnsAllPropertiesOfColorThenFlatRentIsDoubled() {
        val group = Group()
        val street2 = Street("1", 0, 0, 0)
        val street3 = Street("1", 0, 0, 0)
        val street4 = Street("1", 0, 0, 0)
        val player = Player()
        street.owner = player
        street2.owner = player
        street3.owner = player
        street4.owner = player
        group.addProperty(street)
        group.addProperty(street2)
        group.addProperty(street3)
        group.addProperty(street4)

        assertEquals(4, rentCalculator.getRentPrice(street))
    }

    @Test
    fun testWhenStreetHasOneHousesThenRentForOneHousesIsReturned() {
        street.addBuilding(House())

        assertEquals(10, rentCalculator.getRentPrice(street))
    }

    @Test
    fun testWhenStreetHasTwoHousesThenRentForTwoHousesIsReturned() {
        street.addBuilding(House())
        street.addBuilding(House())

        assertEquals(30, rentCalculator.getRentPrice(street))
    }

    @Test
    fun testWhenStreetHasThreeHousesThenRentForThreeHousesIsReturned() {
        street.addBuilding(House())
        street.addBuilding(House())
        street.addBuilding(House())

        assertEquals(90, rentCalculator.getRentPrice(street))
    }

    @Test
    fun testWhenStreetHasFourHousesThenRentForFourHousesIsReturned() {
        street.addBuilding(House())
        street.addBuilding(House())
        street.addBuilding(House())
        street.addBuilding(House())

        assertEquals(160, rentCalculator.getRentPrice(street))
    }

    @Test
    fun testWhenStreetHasHotelThenRentForHotelIsReturned() {
        street.addBuilding(Hotel())

        assertEquals(250, rentCalculator.getRentPrice(street))
    }
}