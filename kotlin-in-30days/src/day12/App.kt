package day12

import java.math.BigDecimal
import java.time.LocalDateTime

fun main() {
    val wallet = Wallet(101, BigDecimal(200), LocalDateTime.now())

    println(wallet.id)
    println(wallet.balance)

//    wallet.balance = BigDecimal(200)
//    wallet.balaceUpdateTime = LocalDateTime.now()

    // wallet.increaseBalance(null)

    wallet.increaseBalance(BigDecimal(100))
    println("結餘(balance): ${wallet.balance}, 修改時間: ${wallet.balaceUpdateTime}")

    wallet.decreaseBalance(BigDecimal(50))
    println("結餘(balance): ${wallet.balance}, 修改時間: ${wallet.balaceUpdateTime}")

    wallet.showPaymentWay()

    println("\n\n wallet2 call\n")
    println("run main constructor in second constructor....")
    val wallet2 = Wallet(102)

    println("\n\n wallet3 call\n")
    println("run third constructor....")
    val wallet3 = Wallet()

}

class Foo private constructor(val someData: String) {
    companion object {
        fun constructorA(): Foo {
            // do stuff
            return Foo("someData")
        }
    }
}