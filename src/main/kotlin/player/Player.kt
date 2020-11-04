package player

import payment.Bill
import payment.Payable

class Player(var name: String = "") : Payable {
    var token: Token = Token()
    override val bills: MutableList<Bill> = mutableListOf()

    override fun getTotalCash(): Int {
        return bills.sumBy { it.amount }
    }
}