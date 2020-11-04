package board

import board.space.Card
import board.space.ChanceCard
import junit.framework.TestCase.assertTrue
import org.junit.Test

class ChanceTest {
    @Test
    fun testBasic() {
        val chanceCard = ChanceCard()

        assertTrue(chanceCard.pickCard() is Card)
    }
}