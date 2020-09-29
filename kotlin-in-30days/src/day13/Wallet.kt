package day13

import java.math.BigDecimal
import java.time.LocalDateTime

class PaymentWay(val name: String)

open class Wallet(val id: Long, _balance: BigDecimal, _createTime: LocalDateTime) {

    var balance = _balance
        get() {
            println("取得 balance: $field")
            return field
        }
        private set(value) {
            println("更新 balance: $value")
            field = value
        }

    var createTime = _createTime
        get() {
            println("取得 createTime: $field")
            return field
        }
        private set(value) {
            println("更新 createTime: $value")
            field = value
        }

    private var balanceUpdateTime: LocalDateTime? = null
        private set(value) {
            println("更新 balance 時間: $value")
            field = value
        }

    protected open var paymentWay: PaymentWay? = PaymentWay("Apple Pay")

    init {
        println("run init1")
        paymentWay = PaymentWay("XXX Pay")
        require(balance >= BigDecimal.ZERO) { "錢包金額必須大於或等於 0" }
    }

    // 第二個 constructor
    constructor(id: Long) : this(id, BigDecimal(0), LocalDateTime.now()) {
        println("run second constructor")
    }

    init {
        println("run init2")
    }

    fun showPaymentWay() {
        paymentWay?.let { println(it.name) }
    }

    fun showBalance(): BigDecimal {
        return balance
    }

    open fun increaseBalance(amount: BigDecimal) {
        println("儲值...$amount")
        if (amount < BigDecimal.ZERO) throw RuntimeException("輸入金額必須大於或等於 0")

        balance = balance.add(amount)
        balanceUpdateTime = LocalDateTime.now()
    }

    fun decreaseBalance(amount: BigDecimal) {
        println("消費金額...$amount")
        // if (amount.compareTo(BigDecimal.ZERO) < 0) throw RuntimeException("金額必須大於或等於 0")
        if (amount < BigDecimal.ZERO) throw RuntimeException("金額必須大於或等於 0")
        if (amount > balance) throw RuntimeException("輸入金額不能大於結餘(balance)")

        balance = balance.subtract(amount)
        balanceUpdateTime = LocalDateTime.now()
    }


}