package gameplay.rules

import space.Group
import space.Street
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Before
import org.junit.Test
import payment.Bank
import payment.Bill
import player.Player

class LandOnOtherPlayersPropertyRuleTest {
    lateinit var landOnOtherPlayersPropertyAction: LandOnOtherPlayersPropertyRule
    private lateinit var street: Street
    lateinit var player: Player
    lateinit var bank: Bank

    @Before
    fun setUp() {
        landOnOtherPlayersPropertyAction = LandOnOtherPlayersPropertyRule()
        street = Street("Dorpsstraat", 60, 2, 10, 30, 90, 160, 250, 50, 30)
        val group = Group()
        group.addProperty(street)
        player = Player()
        player.bills.add(Bill(200))
        bank = Bank()
    }

    @Test
    fun testWhenPropertyIsUnownedThenRuleDoesNotApply() {
        assertFalse(landOnOtherPlayersPropertyAction.ruleApplies(street, player))
    }

    @Test
    fun testWhenPropertyIsOwnedByPlayerThenRuleDoesNotApply() {
        street.owner = player

        assertFalse(landOnOtherPlayersPropertyAction.ruleApplies(street, player))
    }

    @Test
    fun testWhenPropertyIsOwnedByOtherPlayerThenRuleDoesApply() {
        street.owner = Player("Other player")

        assertTrue(landOnOtherPlayersPropertyAction.ruleApplies(street, player))
    }

    @Test
    fun testWhenLadingOnOtherPlayersStreetThenRentIsPayedToOwner() {
        val otherPlayer = Player()
        street.owner = otherPlayer

        landOnOtherPlayersPropertyAction.execute(street, player, Bank())

        assertTrue(otherPlayer.getTotalCash() > 0)
    }

    @Test
    fun testWhenLadingOnOtherPlayersStreetThenRentIsDeductedFromPlayer() {
        val otherPlayer = Player()
        street.owner = otherPlayer

        landOnOtherPlayersPropertyAction.execute(street, player, Bank())

        assertTrue(player.getTotalCash() == 0)
    }
}