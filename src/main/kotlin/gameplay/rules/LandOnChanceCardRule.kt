package gameplay.rules

import space.ChanceCard
import board.Space
import payment.Payable
import payment.PaymentHandler
import payment.PaymentInformation
import player.Player
import kotlin.math.abs

class LandOnChanceCardRule : SpaceRule {
    private val paymentHandler = PaymentHandler()

    override fun ruleApplies(space: Space, player: Player): Boolean {
        return space is ChanceCard
    }

    override fun execute(space: Space, player: Player, payable: Payable, amountRolled: Int) {
        val chest = space as ChanceCard

        val randomCard = chest.pickCard()

        println(player.name + " landt op chance card")
        println(randomCard.description + ": " + randomCard.price)

        if (randomCard.price > 0) {
            return paymentHandler.pay(PaymentInformation(randomCard.price, payable, player))
        }

        // if player cannot pay, skip for now
        if (player.getTotalCash() < randomCard.price) {
            return;
        }

        return paymentHandler.pay(PaymentInformation(abs(randomCard.price), player, payable))
    }
}
