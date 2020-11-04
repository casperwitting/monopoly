package gameplay.rules

import board.space.CommunityChest
import board.space.Street
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test

import payment.Bank
import payment.Bill
import player.Player

class LandOnCommunityChestRuleTest {
    lateinit var landOnCommunityChest: LandOnCommunityChestRule
    lateinit var player: Player
    lateinit var bank: Bank

    @Before
    fun setUp() {
        landOnCommunityChest = LandOnCommunityChestRule()
        player = Player()
        bank = Bank()
    }

    @Test
    fun testWhenSpaceIsStreetThenRuleDoesNotApply() {
        val space = Street("Dorpsstraat", 60, 2, 10, 30, 90, 160, 250, 50, 30)

        TestCase.assertFalse(landOnCommunityChest.ruleApplies(space, player))
    }

    @Test
    fun testWhenSpaceIsCommunityChestThenRuleDoesApply() {
        val space = CommunityChest()

        TestCase.assertTrue(landOnCommunityChest.ruleApplies(space, player))
    }

    @Test
    fun testWhenLandingOnCommunityChestThenRandomCardWillSubtractOrAddedToPlayersMoney() {
        val space = CommunityChest()
        player.bills.add(Bill(500))
        bank.bills.add(Bill(500))

        landOnCommunityChest.execute(space, player, bank)

        TestCase.assertTrue(player.getTotalCash() != 500)
    }

    @Test
    fun testWhenLandingOnCommunityChestThenRandomCardWillSubtractOrAddToBankMoney() {
        val space = CommunityChest()
        player.bills.add(Bill(500))
        bank.bills.add(Bill(500))

        landOnCommunityChest.execute(space, player, bank)

        TestCase.assertTrue(bank.getTotalCash() != 500)
    }
}