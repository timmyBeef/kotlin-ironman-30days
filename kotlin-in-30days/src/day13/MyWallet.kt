package day13

import java.math.BigDecimal

class MyWallet : Wallet {

    constructor(id: Long) : super(id)

    override var paymentWay: PaymentWay? = PaymentWay("My Apple pay")

    override fun increaseBalance(amount: BigDecimal) {
        println("MyWallet super.balance ${super.balance}")
        super.increaseBalance(amount)
        println("MyWallet increaseBalance $amount")
    }

}