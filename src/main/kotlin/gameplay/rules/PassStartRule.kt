package gameplay.rules

import board.Space
import space.Start
import payment.Payable
import payment.PaymentHandler
import payment.PaymentInformation
import player.Player

class PassStartRule : SpaceRule {
    private val paymentHandler = PaymentHandler()

    override fun ruleApplies(space: Space, player: Player): Boolean {
        return space is Start
    }

    override fun execute(space: Space, player: Player, payable: Payable, amountRolled: Int) {
        paymentHandler.pay(
            PaymentInformation(space.price, payable, player)
        )
    }
}