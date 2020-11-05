package gameplay.rules

import space.RailRoad
import space.Street
import space.Utility
import junit.framework.TestCase.*
import org.junit.Before
import org.junit.Test
import payment.Bank
import payment.Bill
import player.Player

class LandOnUnownedPropertyRuleTest {
    lateinit var landOnUnownedPropertyAction: LandOnUnownedPropertyRule
    private lateinit var street: Street
    lateinit var player: Player
    lateinit var bank: Bank

    @Before
    fun setUp() {
        landOnUnownedPropertyAction = LandOnUnownedPropertyRule()
        street = Street("Dorpsstraat", 60, 2, 10, 30, 90, 160, 250, 50, 30)
        player = Player()
        bank = Bank()
    }

    @Test
    fun testWhenPropertyIsAlreadyOwnedThenRuleDoesNotApply() {
        street.owner = player

        assertFalse(landOnUnownedPropertyAction.ruleApplies(street, player))
    }

    @Test
    fun testWhenPropertyIsUnownedThenRuleDoesApply() {

        assertTrue(landOnUnownedPropertyAction.ruleApplies(street, player))
    }

    @Test
    fun testWhenDoesNotHaveTheMoneyToPayForPropertyThenPlayerDoesNotBecomeOwner() {
        player.bills.add(Bill(10))

        landOnUnownedPropertyAction.execute(street, player, bank)

        assertFalse(street.isOwned())
    }

    @Test
    fun testWhenDoesNotHaveTheMoneyToPayForPropertyThenPlayersMoneyStaysTheSame() {
        player.bills.add(Bill(10))

        landOnUnownedPropertyAction.execute(street, player, bank)

        assertEquals(10, player.getTotalCash())
    }

    @Test
    fun testWhenLandingOnEmptyPropertyThenPlayerBecomesOwner() {
        player.bills.add(Bill(200))

        landOnUnownedPropertyAction.execute(street, player, bank)

        assertEquals(player, street.owner)
    }

    @Test
    fun testWhenLandingOnEmptyPropertyThenPlayersMoneyIsDeducted() {
        player.bills.add(Bill(200))

        landOnUnownedPropertyAction.execute(street, player, bank)

        assertTrue(player.getTotalCash() < 100)
    }

    @Test
    fun testWhenLandingOnEmptyPropertyThenBankMoneyIncreases() {
        player.bills.add(Bill(200))

        landOnUnownedPropertyAction.execute(street, player, bank)

        assertTrue(bank.getTotalCash() > 0)
    }

    @Test
    fun testWhenLandingOnEmptyUtilityThenPlayerBecomesOwner() {
        val utility = Utility("ENERGIECENTRALE")
        player.bills.add(Bill(200))

        landOnUnownedPropertyAction.execute(utility, player, bank)

        assertEquals(player, utility.owner)
    }

    @Test
    fun testWhenLandingOnEmptyRailRoadThenPlayerBecomesOwner() {
        val railRoad = RailRoad("STATION ZUID")
        player.bills.add(Bill(200))

        landOnUnownedPropertyAction.execute(railRoad, player, bank)

        assertEquals(player, railRoad.owner)
    }
}

