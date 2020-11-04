package board.space

import player.Player

interface Ownable {
    fun isOwned() : Boolean
    var owner: Player
}