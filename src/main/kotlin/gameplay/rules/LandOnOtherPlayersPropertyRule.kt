package gameplay.rules

import board.*
import space.Property
import board.Space
import payment.Payable
import payment.PaymentHandler
import payment.PaymentInformation
import player.Player

/*
 * When a player lands on an unowned property, property is always bought by player
 */
class LandOnOtherPlayersPropertyRule : SpaceRule {
    private val paymentHandler = PaymentHandler()
    private val rentCalculator = RentCalculator()

    override fun ruleApplies(space: Space, player: Player): Boolean {
        return space is Property && space.isOwned() && space.owner != player
    }

    override fun execute(space: Space, player: Player, payable: Payable, amountRolled: Int) {
        val property = space as Property

        val rentToPay = rentCalculator.getRentPrice(property, amountRolled)

        if (player.getTotalCash() < rentToPay) {
            return;
        }

        paymentHandler.pay(PaymentInformation(rentToPay, player, property.owner))
    }
}