package gameplay.rules

import space.Property
import board.Space
import payment.Payable
import payment.PaymentHandler
import payment.PaymentInformation
import player.Player

/*
 * When a player lands on an unowned property, property is always bought by player
 */
class LandOnUnownedPropertyRule : SpaceRule {
    private val paymentHandler = PaymentHandler()

    override fun ruleApplies(space: Space, player: Player): Boolean {
        return space is Property && !space.isOwned()
    }

    override fun execute(space: Space, player: Player, payable: Payable, amountRolled: Int) {
        val property = space as Property

        if (player.getTotalCash() < property.price) {
            return;
        }

        property.owner = player;

        paymentHandler.pay(PaymentInformation(property.price, player, payable))
    }
}