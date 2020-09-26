package day17

// sealed class ex1
sealed class Code {
    data class RCode(val number: Double) : Code()
    data class VCode(val name: String, val code: String) : Code()
    object ZCode : Code()

    companion object {
        fun getCode(code: Code): String {
            return when (code) {
                is RCode -> "RCode type"
                is VCode -> "VCode type"
                is ZCode -> "ZCode type"
            }
        }
    }
}

// sealed class ex2
sealed class Code2

data class RCode(val number: Double) : Code2()
data class VCode(val name: String, val code: String) : Code2()
object ZCode : Code2()

fun getCode(code: Code2): String {
    return when (code) {
        is RCode -> "RCode type"
        is VCode -> "VCode type"
        is ZCode -> "ZCode type"
    }
}

// 一般 class 試試看
open class Code3
data class RCodeX(val number: Double) : Code3()
data class VCodeX(val name: String, val code: String) : Code3()
object ZCodeX : Code3()

fun getCode(code: Code3): String {
    return when (code) {
        is RCodeX -> "RCode type"
        is VCodeX -> "VCode type"
        is ZCodeX -> "ZCode type"
        else -> "not match"
    }
}

fun main() {
    println(PaymentRtnCode.getType("1")) // 系統維護中
    println(PaymentRtnCode2.getType("1"))// 系統維護中

    println(Code.getCode(Code.RCode(123.2)))

    println(getCode(RCode(123.2)))

}

