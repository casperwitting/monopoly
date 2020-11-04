package payment

import player.Player
import junit.framework.Assert.assertEquals
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class PaymentHandlerTest {
    private val paymentHandler: PaymentHandler = PaymentHandler()
    lateinit var player: Player
    lateinit var bank: Bank

    @Before
    fun setUp() {
        player = Player()
        bank = Bank()
    }

    @Test(expected = PaymentFailedException::class)
    fun testWhenPlayerHasNotEnoughMoneyThenCannotPayAmount() {
        paymentHandler.pay(PaymentInformation(amount = 200, player = player, receiver = bank))
    }

    @Test()
    fun testWhenPlayerHasTheBillWithExactAmountThenAmountIsSubtracted() {
        player.bills.add(Bill(100))
        player.bills.add(Bill(100))
        player.bills.add(Bill(100))

        paymentHandler.pay(PaymentInformation(amount = 100, player = player, receiver = bank))

        Assert.assertEquals(200, player.getTotalCash())
    }

    @Test()
    fun testWhenPlayerHasMultipleBillsThatComputeToExactAmountThenBillsAreSubtracted() {
        player.bills.add(Bill(100))
        player.bills.add(Bill(100))
        player.bills.add(Bill(100))

        paymentHandler.pay(PaymentInformation(amount = 200, player = player, receiver = bank))

        Assert.assertEquals(100, player.getTotalCash())
    }

    @Test()
    fun testWhenPlayerHasBillsThatComputeToExceedingAmountThenBillsAreSubtracted() {
        player.bills.add(Bill(100))
        player.bills.add(Bill(100))
        player.bills.add(Bill(100))

        paymentHandler.pay(PaymentInformation(amount = 201, player = player, receiver = bank))

        Assert.assertEquals(0, player.getTotalCash())
    }

    @Test
    fun testWhenPayingOtherPlayerCanOnlyPayExceedingAmountThenReceiverReceivesExceedingAmount() {
        player.bills.add(Bill(100))
        player.bills.add(Bill(100))

        paymentHandler.pay(PaymentInformation(amount = 150, player = player, receiver = bank))

        assertEquals(200, bank.getTotalCash())
    }

    @Test()
    fun testWhenPayingThenHighestBillsAreSubtractedFirst() {
        val bill1 = Bill(1)
        val bill2 = Bill(25)
        val bill3 = Bill(1)
        val bill4 = Bill(100)
        val bill5 = Bill(1)
        val bill6 = Bill(25)
        val bill7 = Bill(1)

        player.bills.addAll(listOf(bill1, bill2, bill3, bill4, bill5, bill6, bill7))

        paymentHandler.pay(PaymentInformation(amount = 150, player = player, receiver = bank))

        Assert.assertTrue(player.bills.containsAll(listOf(bill1, bill3, bill5, bill7)))
        Assert.assertFalse(player.bills.contains(bill2))
        Assert.assertFalse(player.bills.contains(bill4))
        Assert.assertFalse(player.bills.contains(bill6))
    }

    @Test
    fun testWhenPayingOtherPlayerThenReceiverGainsAmount() {
        player.bills.add(Bill(100))

        paymentHandler.pay(PaymentInformation(amount = 100, player = player, receiver = bank))

        assertEquals(100, bank.getTotalCash())
    }

    @Test
    fun testWhenPayingOtherPlayerPaysWithMultipleBillsThenReceiverReceivesMultipleBills() {
        player.bills.add(Bill(100))
        player.bills.add(Bill(100))
        player.bills.add(Bill(100))
        player.bills.add(Bill(100))

        paymentHandler.pay(PaymentInformation(amount = 400, player = player, receiver = bank))

        assertEquals(4, bank.bills.count())
    }

    @Test
    fun testWhenPlayerHasHigherNotExactBillThenItWillNotBeSubtractedFirst() {
        player.bills.add(Bill(50))
        player.bills.add(Bill(50))
        player.bills.add(Bill(50))
        player.bills.add(Bill(10))
        player.bills.add(Bill(5))
        player.bills.add(Bill(1))

        paymentHandler.pay(PaymentInformation(amount = 120, player = player, receiver = bank))

        assertEquals(16, player.getTotalCash())
    }

    @Test
    fun testWhenPlayerHasHigherNotExactBillThenItWillNotBeSubtractedFirst2() {
        player.bills.add(Bill(500))
        player.bills.add(Bill(200))
        player.bills.add(Bill(100))
        player.bills.add(Bill(100))
        player.bills.add(Bill(50))
        player.bills.add(Bill(50))
        player.bills.add(Bill(10))

        paymentHandler.pay(PaymentInformation(amount = 260, player = player, receiver = bank))

        assertEquals(750, player.getTotalCash())
    }

    @Test
    fun testWhenPlayerHasHigherNotExactBillThenItWillNotBeSubtractedFirst3() {
        player.bills.add(Bill(500))
        player.bills.add(Bill(200))
        player.bills.add(Bill(100))
        player.bills.add(Bill(100))
        player.bills.add(Bill(50))
        player.bills.add(Bill(50))
        player.bills.add(Bill(20))

        paymentHandler.pay(PaymentInformation(amount = 120, player = player, receiver = bank))

        assertEquals(900, player.getTotalCash())
    }
}