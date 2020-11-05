package gameplay.rules

import space.CommunityChest
import space.Start
import space.housableproperty.Street
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test

import payment.Bank
import payment.Bill
import player.Player

class PassStartRuleTest {
    lateinit var passStartAction: PassStartRule
    lateinit var player: Player

    @Before
    fun setUp() {
        passStartAction = PassStartRule()
        player = Player()
    }

    @Test
    fun testWhenSpaceIsStreetThenRuleDoesNotApply() {
        val space = Street(
            description = "Dorpsstraat",
            price = 60,
            costOfHouse = 50,
            mortgageValue = 30
        )

        TestCase.assertFalse(passStartAction.ruleApplies(space, player))
    }

    @Test
    fun testWhenSpaceIsCommunityChestThenRuleDoesNotApply() {
        val space = CommunityChest()

        TestCase.assertFalse(passStartAction.ruleApplies(space, player))
    }

    @Test
    fun testWhenSpaceIsIncomeTaxThenRuleDoesNotApply() {
        val space = Start()

        TestCase.assertTrue(passStartAction.ruleApplies(space, player))
    }

    @Test
    fun testWhenSpaceIsStartThenRuleDoesApply() {
        val space = Start()

        TestCase.assertTrue(passStartAction.ruleApplies(space, player))
    }

    @Test
    fun testWhenPlayerLandsOnIncomeTaxThenTheTaxAmountWillBeSubtractedFromPlayersMoney() {
        val space = Start()
        val bank = Bank()
        bank.bills.add(Bill(100))
        bank.bills.add(Bill(100))
        bank.bills.add(Bill(100))
        bank.bills.add(Bill(100))

        passStartAction.execute(space, player, bank)

        TestCase.assertTrue(bank.getTotalCash() < 400)
    }

    @Test
    fun testWhenPlayerLandsOnIncomeTaxThenTaxWillBePayedToBank() {
        val space = Start()
        val bank = Bank()
        bank.bills.add(Bill(100))
        bank.bills.add(Bill(100))
        bank.bills.add(Bill(100))
        bank.bills.add(Bill(100))

        passStartAction.execute(space, player, bank)

        TestCase.assertTrue(player.getTotalCash() > 0)
    }
}