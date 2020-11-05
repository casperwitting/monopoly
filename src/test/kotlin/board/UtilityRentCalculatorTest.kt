package board

import space.property.Group
import space.property.Utility
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test
import player.Player
import space.RentCalculator

class UtilityRentCalculatorTest {
    private lateinit var utility1: Utility
    private lateinit var utility2: Utility
    private lateinit var utility3: Utility
    private lateinit var player: Player
    private lateinit var rentCalculator: RentCalculator

    @Before
    fun setUp() {
        utility1 = Utility("Gasfabriek")
        utility2 = Utility("Elektriciteit")
        utility3 = Utility("Groentecentrum")
        val group = Group()
        group.addProperty(utility1)
        group.addProperty(utility2)
        group.addProperty(utility3)
        player = Player("Arie")
        rentCalculator = RentCalculator()
    }

    @Test
    fun testWhenUtilityOwnerOwnsSingleUtilityThenRentIsFourTimesTheRolledAmount() {
        utility1.owner = player

        assertEquals(4, rentCalculator.getRentPrice(utility1, 1))
    }

    @Test
    fun testWhenUtilityOwnerOwnsTwoUtilitiesThenRentIsTentTimesTheRolledAmount() {
        utility1.owner = player
        utility2.owner = player

        assertEquals(10, rentCalculator.getRentPrice(utility1, 1))
    }

    @Test
    fun testWhenUtilityOwnerOwnsThreeUtilitiesThenRentIsTwentyTimesTheRolledAmount() {
        utility1.owner = player
        utility2.owner = player
        utility3.owner = player

        assertEquals(20, rentCalculator.getRentPrice(utility1, 1))
    }
}