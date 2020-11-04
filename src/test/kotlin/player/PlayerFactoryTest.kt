package player

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.junit.Before
import org.junit.Test

class PlayerFactoryTest {
    lateinit var playerFactory: PlayerFactory

    @Before
    fun setUp() {
        playerFactory = PlayerFactory()
    }

    @Test
    fun testCreatePlayerWithGivenName() {
        val player = playerFactory.createPlayer("Casper", "🚗")

        assertEquals("Casper", player.name)
    }

    @Test
    fun testWhenCreatingPlayerThenPlayerHasStartingMoney() {
        val player = playerFactory.createPlayer("Casper", "🚗")

        assertTrue(player.getTotalCash() > 0)
    }
}