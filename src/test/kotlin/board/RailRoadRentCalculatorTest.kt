package board

import space.property.Group
import space.property.RailRoad
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test
import player.Player
import space.RentCalculator

class RailRoadRentCalculatorTest {
    private lateinit var railRoad1: RailRoad
    private lateinit var railRoad2: RailRoad
    private lateinit var railRoad3: RailRoad
    private lateinit var railRoad4: RailRoad
    private lateinit var player: Player
    private lateinit var rentCalculator: RentCalculator

    @Before
    fun setUp() {
        railRoad1 = RailRoad("Station Noord")
        railRoad2 = RailRoad("Station Oost")
        railRoad3 = RailRoad("Station Zuid")
        railRoad4 = RailRoad("Station West")
        val group = Group()
        group.addProperty(railRoad1)
        group.addProperty(railRoad2)
        group.addProperty(railRoad3)
        group.addProperty(railRoad4)
        player = Player("Arie")
        rentCalculator = RentCalculator()
    }

    @Test
    fun testWhenRailRoadOwnerOwnsOneRailRoadThenRentIsTwentyFive() {
        railRoad1.owner = player

        assertEquals(25, rentCalculator.getRentPrice(railRoad1))
    }

    @Test
    fun testWhenRailRoadOwnerOwnsTwoRailRoadsThenRentIsFifty() {
        railRoad1.owner = player
        railRoad2.owner = player

        assertEquals(50, rentCalculator.getRentPrice(railRoad1))
    }

    @Test
    fun testWhenRailRoadOwnerOwnsThreeRailRoadsThenRentIsHundred() {
        railRoad1.owner = player
        railRoad2.owner = player
        railRoad3.owner = player

        assertEquals(100, rentCalculator.getRentPrice(railRoad1))
    }

    @Test
    fun testWhenRailRoadOwnerOwnsFourRailRoadsThenRentIsTwoHundred() {
        railRoad1.owner = player
        railRoad2.owner = player
        railRoad3.owner = player
        railRoad4.owner = player

        assertEquals(200, rentCalculator.getRentPrice(railRoad1))
    }
}