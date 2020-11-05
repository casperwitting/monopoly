package gameplay.rules

import space.Street
import junit.framework.TestCase.*
import org.junit.Before
import org.junit.Test
import payment.Bank
import payment.Bill
import player.Player

class LandOnOwnHousablePropertyRuleTest {
    lateinit var landOnOwnPropertyAction: LandOnOwnPropertyRule
    private lateinit var street: Street
    lateinit var player: Player
    lateinit var bank: Bank

    @Before
    fun setUp() {
        landOnOwnPropertyAction = LandOnOwnPropertyRule()
        street = Street("Dorpsstraat", 60, 2, 10, 30, 90, 160, 250, 50, 30)
        player = Player()
        bank = Bank()
    }

    @Test
    fun testWhenPropertyIsAlreadyOwnedByPlayerThenRuleDoesApply() {
        street.owner = player

        assertTrue(landOnOwnPropertyAction.ruleApplies(street, player))
    }

    @Test
    fun testWhenPropertyIsUnownedThenRuleDoesNotApply() {
        assertFalse(landOnOwnPropertyAction.ruleApplies(street, player))
    }

    @Test
    fun testWhenDoesNotHaveTheMoneyToPayForPropertyThenPlayerStaysOwnerOfStreet() {
        player.bills.add(Bill(10))
        street.owner = player

        landOnOwnPropertyAction.execute(street, player, bank)

        assertTrue(street.owner == player)
    }

    @Test
    fun testWhenDoesNotHaveTheMoneyToPayForPropertyThenPlayersMoneyStaysTheSame() {
        player.bills.add(Bill(10))

        landOnOwnPropertyAction.execute(street, player, bank)

        assertEquals(10, player.getTotalCash())
    }

    @Test
    fun testWhenBuyingAnotherHouseOnStreetThenPlayersMoneyIsDeducted() {
        player.bills.add(Bill(100))

        landOnOwnPropertyAction.execute(street, player, bank)

        assertTrue(player.getTotalCash() < 100)
    }

    @Test
    fun testWhenBuyingAnotherHouseOnStreetThenBankMoneyIncreases() {
        player.bills.add(Bill(100))

        landOnOwnPropertyAction.execute(street, player, bank)

        assertTrue(bank.getTotalCash() > 0)
    }
}

