package gameplay.rules

import space.CommunityChest
import board.IncomeTax
import space.Street
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test

import payment.Bank
import payment.Bill
import player.Player

class LandOnIncomeTaxRuleTest {
    lateinit var landOnIncomeTaxAction: LandOnIncomeTaxRule

    @Before
    fun setUp() {
        landOnIncomeTaxAction = LandOnIncomeTaxRule()
    }

    @Test
    fun testWhenSpaceIsStreetThenRuleDoesNotApply() {
        val space = Street("Dorpsstraat", 60, 2, 10, 30, 90, 160, 250, 50, 30)
        val player = Player()

        TestCase.assertFalse(landOnIncomeTaxAction.ruleApplies(space, player))
    }

    @Test
    fun testWhenSpaceIsCommunityChestThenRuleDoesNotApply() {
        val space = CommunityChest()
        val player = Player()

        TestCase.assertFalse(landOnIncomeTaxAction.ruleApplies(space, player))
    }

    @Test
    fun testWhenSpaceIsIncomeTaxThenRuleDoesApply() {
        val space = IncomeTax()
        val player = Player()

        TestCase.assertTrue(landOnIncomeTaxAction.ruleApplies(space, player))
    }

    @Test
    fun testWhenPlayerLandsOnIncomeTaxThenTheTaxAmountWillBeSubtractedFromPlayersMoney() {
        val space = IncomeTax()
        val player = Player()
        player.bills.add(Bill(100))
        player.bills.add(Bill(100))
        player.bills.add(Bill(100))
        player.bills.add(Bill(100))
        val bank = Bank()

        landOnIncomeTaxAction.execute(space, player, bank)

        TestCase.assertTrue(player.getTotalCash() < 400)
    }

    @Test
    fun testWhenPlayerLandsOnIncomeTaxThenTaxWillBePayedToBank() {
        val space = IncomeTax()
        val player = Player()
        player.bills.add(Bill(100))
        player.bills.add(Bill(100))
        player.bills.add(Bill(100))
        player.bills.add(Bill(100))
        val bank = Bank()

        landOnIncomeTaxAction.execute(space, player, bank)

        TestCase.assertTrue(bank.getTotalCash() > 0)
    }
}