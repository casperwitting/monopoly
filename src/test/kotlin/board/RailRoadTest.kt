package board

import space.property.RailRoad
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test
import player.Player

class RailRoadTest {
    private lateinit var railRoad : RailRoad
    @Before
    fun setUp() {
        railRoad = RailRoad("station zuid")
    }

    @Test
    fun testChangeRailRoadOwner() {
        val player = Player("John Doe")
        railRoad.owner = player

        TestCase.assertEquals(player, railRoad.owner)
    }

    @Test
    fun testRailRoadPriceIsSetByDefault() {
        TestCase.assertTrue(railRoad.price > 0)
    }
}