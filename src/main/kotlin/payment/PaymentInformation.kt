package payment

data class PaymentInformation(var amount: Int, val player: Payable, val receiver: Payable)