package day12

import java.math.BigDecimal
import java.time.LocalDateTime

class PaymentWay(val name: String)

class Wallet(val id: Long, _balance: BigDecimal, _createTime: LocalDateTime) {

    var balance = _balance
        get() {
            println("取得 balance: $field")
            return field
        }
        private set(value) {
            println("更新 balance: $value")
            field = value
        }

    var balaceUpdateTime: LocalDateTime? = null
        private set(value) {
            println("更新 balance 時間: $value")
            field = value
        }

    var paymentWay: PaymentWay? = PaymentWay("Apple Pay")

    init {
        println("run init1")
        paymentWay = PaymentWay("XXX Pay")
        require(balance >= BigDecimal.ZERO) { "錢包金額必須大於或等於 0" }
    }

    // 第二個 constructor
    constructor(id: Long) : this(id, BigDecimal(0), LocalDateTime.now()) {
        println("run Secondary constructor")
    }

    // 第三個 constructor
    constructor() : this(123, BigDecimal(0), LocalDateTime.now()) {
        println("run third constructor")
    }

    init {
        println("run init2")
    }

    fun showPaymentWay() {
        paymentWay?.let { println(it.name) }
    }

    fun increaseBalance(amount: BigDecimal) {
        println("儲值...$amount")
        if (amount < BigDecimal.ZERO) throw RuntimeException("輸入金額必須大於或等於 0")

        balance = balance.add(amount)
        balaceUpdateTime = LocalDateTime.now()
    }

    fun decreaseBalance(amount: BigDecimal) {
        println("消費金額...$amount")
        // if (amount.compareTo(BigDecimal.ZERO) < 0) throw RuntimeException("金額必須大於或等於 0")
        if (amount < BigDecimal.ZERO) throw RuntimeException("金額必須大於或等於 0")
        if (amount > balance) throw RuntimeException("輸入金額不能大於結餘(balance)")

        balance = balance.subtract(amount)
        balaceUpdateTime = LocalDateTime.now()
    }


}