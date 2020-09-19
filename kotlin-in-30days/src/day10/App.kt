package day10

import java.math.BigDecimal
import java.time.LocalDateTime

fun main() {
    val wallet = Wallet(101, BigDecimal(200), LocalDateTime.now())

    println(wallet.id)
    println(wallet.balance)

    wallet.balance = BigDecimal(200)
    wallet.balaceUpdateTime = LocalDateTime.now()
}