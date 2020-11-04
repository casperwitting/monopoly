package gameplay

import payment.Bank
import player.Player
import board.Board

class Game {
    lateinit var bank: Bank
    lateinit var board: Board
    val players: MutableList<Player> = mutableListOf()
}
