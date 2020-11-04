package payment

interface Payable {
    val bills: MutableList<Bill>

    fun getTotalCash(): Int
}