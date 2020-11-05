package gameplay.rules

import board.House
import space.HousableProperty
import board.Space
import payment.Payable
import payment.PaymentHandler
import payment.PaymentInformation
import player.Player
import kotlin.math.abs

class LandOnOwnPropertyRule : SpaceRule {
    private val paymentHandler = PaymentHandler()

    override fun ruleApplies(space: Space, player: Player) : Boolean {
        return space is HousableProperty && space.isOwned() && space.owner == player
    }

    override fun execute(space: Space, player: Player, payable: Payable, amountRolled: Int) {
        val property = space as HousableProperty
        val amount = abs(property.price)

        if (player.getTotalCash() < amount) {
            return;
        }

        paymentHandler.pay(PaymentInformation(amount, player, payable))

        // TODO: 23/10/2020 make player already have houses and hotels form the start by including this in the board builder
        val house = House()
        property.buildings.add(house)
    }
}