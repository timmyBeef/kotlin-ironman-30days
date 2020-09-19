package day10

import java.math.BigDecimal
import java.time.LocalDateTime

class Wallet(val id: Long, _balance: BigDecimal, _createTime: LocalDateTime) {
    var balance = _balance
        get() {
            println("取得 balance: $field")
            return field
        }
        set(value) {
            println("更新 balance: $value")
            field = value
        }

    var balaceUpdateTime: LocalDateTime? = null
        set(value) {
            println("更新 balance 時間: $value")
            field = value
        }
}