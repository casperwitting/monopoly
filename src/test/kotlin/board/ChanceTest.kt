package board

import space.Card
import space.ChanceCard
import junit.framework.TestCase.assertTrue
import org.junit.Test

class ChanceTest {
    @Test
    fun testBasic() {
        val chanceCard = ChanceCard()

        assertTrue(chanceCard.pickCard() is Card)
    }
}