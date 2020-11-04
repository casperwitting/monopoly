package gameplay

import board.BoardFactory
import payment.Bank
import payment.Bill
import player.Player
import player.PlayerFactory

class GameFactory {
    private val boardFactory = BoardFactory()
    private val playerFactory = PlayerFactory()
    private val bankMoneyMap = mapOf(
        500 to 20,
        100 to 20,
        50 to 30,
        20 to 50,
        10 to 40,
        5 to 40,
        1 to 40
    )

    fun newGame(): Game {
        val game = Game()

        game.players.addAll(
            listOf(
                playerFactory.createPlayer("Casper", "🚗"),
                playerFactory.createPlayer("Niels", "🚢"),
                playerFactory.createPlayer("Viv", "🎩")
            )
        )

        val bank = Bank()
        bank.bills.addAll(
            convertMapToBills(bankMoneyMap)
        )

        game.bank = bank
        game.board = boardFactory.makeBoard()

        return game
    }

    private fun convertMapToBills(map: Map<Int, Int>): Collection<Bill> {
        val list = mutableListOf<Bill>()

        for (m in map) {
            repeat(m.value) {
                list.add(Bill(m.key))
            }
        }

        return list;
    }
}
