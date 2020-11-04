package gameplay.rules

import board.IncomeTax
import board.Space
import payment.Payable
import payment.PaymentHandler
import payment.PaymentInformation
import player.Player

class LandOnIncomeTaxRule : SpaceRule {
    private val paymentHandler = PaymentHandler()

    override fun ruleApplies(space: Space, player: Player): Boolean {
        return space is IncomeTax
    }

    override fun execute(space: Space, player: Player, payable: Payable, amountRolled: Int) {
        val incomeTax = space as IncomeTax

        if (player.getTotalCash() < incomeTax.price) {
            return;
        }

        paymentHandler.pay(PaymentInformation(incomeTax.price, player, payable))
    }

}
