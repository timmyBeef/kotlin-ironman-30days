package day13

import java.math.BigDecimal
import java.time.LocalDateTime

fun main() {
    val wallet = Wallet(101, BigDecimal(200), LocalDateTime.now())

    println(wallet.id)
    println(wallet.balance)

    val myWallet = MyWallet(123)
    println(myWallet is Wallet) // true
    println(wallet is MyWallet) // false

    println(wallet is Any) // false

    anyFun(myWallet) //it's MyWallet

    myWallet.increaseBalance(BigDecimal(100))
}

fun anyFun(any: Any) {
    if (any is MyWallet) { // smart cast
        println("it's MyWallet")
        any.decreaseBalance(BigDecimal(0))
    } else {
        println("it's other type")
    }

    (any as MyWallet).decreaseBalance(BigDecimal(0))
}
