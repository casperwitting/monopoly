package payment

import kotlin.math.abs

class PaymentHandler {
    private val billSelector = BillSelector()

    fun pay(paymentInformation: PaymentInformation) {
        val payersTotalCash: Int = paymentInformation.player.getTotalCash()

        if (paymentInformation.amount > payersTotalCash) {
            throw PaymentFailedException("player.Player does not have enough credit to pay this transaction")
        }

        val billsThatCoverAmount = billSelector.getBillsForAmount(paymentInformation.amount, paymentInformation.player)

        fun transferBill(billToTrade: Bill, paymentInformation: PaymentInformation) {
            paymentInformation.receiver.bills.add(billToTrade)
            paymentInformation.player.bills.remove(billToTrade)
        }

        for (bill: Bill in billsThatCoverAmount) {
            transferBill(bill, paymentInformation)
        }
    }
}

