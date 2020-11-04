package gameplay

import junit.framework.TestCase.*
import org.junit.Test
import player.Player
import player.Token

class GameFactoryTest {
    @Test
    fun testNewGame() {
        val gameFactory = GameFactory()
        val game = gameFactory.newGame()

        assertTrue(game.players.count() > 1)
        assertTrue(game.board.spaces.count() > 0)
        assertEquals(15140, game.bank.getTotalCash())

        for (player: Player in game.players) {
            assertEquals(0, player.token.position)
            assertEquals(1500, player.getTotalCash())
        }
    }
}