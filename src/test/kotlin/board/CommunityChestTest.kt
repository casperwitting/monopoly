package board

import space.Card
import space.CommunityChest
import junit.framework.TestCase.assertTrue
import org.junit.Test

class CommunityChestTest {
    @Test
    fun testBasic() {
        val communityChest = CommunityChest()

        assertTrue(communityChest.pickCard() is Card)
    }
}