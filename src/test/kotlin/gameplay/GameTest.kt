package gameplay

import payment.Bank
import player.Player
import board.Board
import junit.framework.TestCase.assertEquals
import org.junit.Test

class GameTest {
    @Test
    fun testAddGetPlayer() {
        val game = Game()
        val player = Player()

        game.players.add(player)
        
        assertEquals(player, game.players.first())
    }

    @Test
    fun testSetGetBoard() {
        val game = Game()
        val board = Board()

        game.board = board

        assertEquals(board, game.board)
    }

    @Test
    fun testSetGetBank() {
        val game = Game()
        val bank = Bank()

        game.bank = bank

        assertEquals(bank, game.bank)
    }
}