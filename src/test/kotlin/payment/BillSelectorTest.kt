package payment

import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test
import player.Player

class BillSelectorTest {
    private lateinit var billSelector : BillSelector
    lateinit var payer : Payable
    @Before
    fun setUp() {
        billSelector = BillSelector()
        payer = Player()
    }

    @Test
    fun testWhenPayerHasSingleBillWithExactAmountThenGetBillForExactAmount() {
        payer.bills.add(Bill(200))

        val billsToCoverAmount = billSelector.getBillsForAmount(200, payer)

        assertEquals(
            listOf(200),
            billsToCoverAmount.map { it.amount }
        )
    }

    @Test(expected = PaymentFailedException::class)
    fun testWhenPayerCannotPayAmountThenGetBillForExactAmount() {
        payer.bills.add(Bill(100))

        billSelector.getBillsForAmount(101, payer)
    }

    @Test
    fun testWhenPayerHasBillsWithExactAmountThenGetBillWithExactAmount() {
        payer.bills.add(Bill(200))
        payer.bills.add(Bill(100))
        payer.bills.add(Bill(50))
        payer.bills.add(Bill(50))
        payer.bills.add(Bill(20))

        val billsToCoverAmount = billSelector.getBillsForAmount(50, payer)

        assertEquals(
            listOf(50),
            billsToCoverAmount.map { it.amount }
        )
    }

    @Test
    fun testWhenPayerNeedsMultipleBillsToPayExactAmountThenGetBills() {
        payer.bills.add(Bill(200))
        payer.bills.add(Bill(100))
        payer.bills.add(Bill(50))
        payer.bills.add(Bill(20))

        val billsToCoverAmount = billSelector.getBillsForAmount(170, payer)

        assertEquals(
            listOf(100, 50, 20),
            billsToCoverAmount.map { it.amount }
        )
    }

    @Test
    fun testWhenPayerNeedsMultipleBillsToPayExceedingAmountThenGetBills() {
        payer.bills.add(Bill(200))
        payer.bills.add(Bill(100))
        payer.bills.add(Bill(50))
        payer.bills.add(Bill(20))

        val billsToCoverAmount = billSelector.getBillsForAmount(110, payer)

        assertEquals(
            listOf(100, 20),
            billsToCoverAmount.map { it.amount }
        )
    }

    @Test
    fun testWhenPayerNeedsMultipleBillsToPayExceedingAmountThenGetBills2() {
        payer.bills.add(Bill(200))
        payer.bills.add(Bill(100))
        payer.bills.add(Bill(50))
        payer.bills.add(Bill(20))

        val billsToCoverAmount = billSelector.getBillsForAmount(175, payer)

        assertEquals(
            listOf(200),
            billsToCoverAmount.map { it.amount }
        )
    }
}