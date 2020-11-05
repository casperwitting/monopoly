package gameplay.rules

import space.ChanceCard
import space.CommunityChest
import space.housableproperty.Street
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test

import payment.Bank
import payment.Bill
import player.Player
import space.housableproperty.NullRentScheme

class LandOnChanceCardRuleTest {
    lateinit var landOnChanceCard: LandOnChanceCardRule
    lateinit var player: Player
    lateinit var bank: Bank

    @Before
    fun setUp() {
        landOnChanceCard = LandOnChanceCardRule()
        player = Player()
        bank = Bank()
    }

    @Test
    fun testWhenSpaceIsStreetThenRuleDoesNotApply() {
        val space = Street(
            description = "Dorpsstraat",
            price = 60,
            costOfHouse = 50,
            mortgageValue = 30
        )

        TestCase.assertFalse(landOnChanceCard.ruleApplies(space, player))
    }

    @Test
    fun testWhenSpaceIsCommunityChestThenRuleDoesNotApply() {
        val space = CommunityChest()

        TestCase.assertFalse(landOnChanceCard.ruleApplies(space, player))
    }

    @Test
    fun testWhenSpaceIsChanceCardThenRuleDoesApply() {
        val space = ChanceCard()

        TestCase.assertTrue(landOnChanceCard.ruleApplies(space, player))
    }

    @Test
    fun testWhenLandingOnCommunityChestThenRandomCardWillSubtractOrAddedToPlayersMoney() {
        val space = ChanceCard()
        player.bills.add(Bill(500))
        bank.bills.add(Bill(500))

        landOnChanceCard.execute(space, player, bank)

        TestCase.assertTrue(player.getTotalCash() != 500)
    }

    @Test
    fun testWhenLandingOnCommunityChestThenRandomCardWillSubtractOrAddToBankMoney() {
        val space = ChanceCard()
        player.bills.add(Bill(500))
        bank.bills.add(Bill(500))

        landOnChanceCard.execute(space, player, bank)

        TestCase.assertTrue(bank.getTotalCash() != 500)
    }
}