package gameplay.rules

import space.CommunityChest
import board.Space
import payment.Payable
import payment.PaymentHandler
import payment.PaymentInformation
import player.Player
import kotlin.math.abs

class LandOnCommunityChestRule : SpaceRule {
    private val paymentHandler = PaymentHandler()

    override fun ruleApplies(space: Space, player: Player): Boolean {
        return space is CommunityChest
    }

    override fun execute(space: Space, player: Player, payable: Payable, amountRolled: Int) {
        val chest = space as CommunityChest

        val randomCard = chest.pickCard()

        println(player.name + " landt op community chest")
        println(randomCard.description + ": " + randomCard.price)

        if (randomCard.price > 0) {
            return paymentHandler.pay(PaymentInformation(randomCard.price, payable, player))
        }

        return paymentHandler.pay(PaymentInformation(abs(randomCard.price), player, payable))
    }
}