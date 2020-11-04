package gameplay.rules

import board.Space
import payment.Payable
import player.Player

interface SpaceRule {
    fun ruleApplies(space: Space, player: Player): Boolean
    fun execute(space: Space, player: Player, payable: Payable, amountRolled: Int = 0)
}