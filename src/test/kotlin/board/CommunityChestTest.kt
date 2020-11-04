package board

import board.space.Card
import board.space.CommunityChest
import junit.framework.TestCase.assertTrue
import org.junit.Test

class CommunityChestTest {
    @Test
    fun testBasic() {
        val communityChest = CommunityChest()

        assertTrue(communityChest.pickCard() is Card)
    }
}