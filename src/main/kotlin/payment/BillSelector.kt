package payment

class BillSelector {
    fun getBillsForAmount(amount: Int, payer: Payable) : MutableList<Bill> {
        var billsLeftToPayWith: MutableList<Bill> = payer.bills.sortedByDescending { it.amount }.toMutableList()
        var billsThatCoverAmount = mutableListOf<Bill>()
        var amountLeftToPay = amount;

        while (amountLeftToPay > 0) {
            if (billsLeftToPayWith.count() == 0) {
                throw PaymentFailedException("Payer does not have the bills to pay the given amount.")
            }

            val currentBill: Bill = billsLeftToPayWith.first()
            billsLeftToPayWith.remove(currentBill)

            if (currentBill.amount > amountLeftToPay && hasSmallerBillsToPayRemainingAmountWith(amountLeftToPay, billsLeftToPayWith)) {
                continue
            }

            billsThatCoverAmount.add(currentBill)
            amountLeftToPay -= currentBill.amount
        }

        return billsThatCoverAmount
    }

    private fun hasSmallerBillsToPayRemainingAmountWith(
        amountLeftToPay: Int,
        billsLeftToPayWith: MutableList<Bill>
    ) = billsLeftToPayWith.sumBy { it.amount } >= amountLeftToPay
}
