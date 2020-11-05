package board

import space.Utility
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test
import player.Player

class UtilityTest {
    private lateinit var utility : Utility
    @Before
    fun setUp() {
        utility = Utility("station zuid")
    }

    @Test
    fun testChangeUtilityOwner() {
        val player = Player("John Doe")
        utility.owner = player

        TestCase.assertEquals(player, utility.owner)
    }

    @Test
    fun testUtilityPriceIsSetByDefault() {
        TestCase.assertTrue(utility.price > 0)
    }
}
