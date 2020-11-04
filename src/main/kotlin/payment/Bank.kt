package payment

class Bank : Payable {
    override val bills: MutableList<Bill> = mutableListOf()

    override fun getTotalCash(): Int {
        return bills.sumBy { it.amount }
    }
}