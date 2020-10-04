package day25

import java.math.BigDecimal

class NumOp(var num: BigDecimal)

fun NumOp.mutiply(num: BigDecimal) {
    this.num *= num;
}


fun String?.trimToUpperCase(): String {
    return this?.trim()?.toUpperCase() ?: ""
}

fun <T> T.easyPrint(): T {
    println(this)
    return this
}

val <T> List<T>.lastIndex: Int
    get() = size - 1

// val List<T>.hahaha = 1 // no backing field, 不能給初始值

class MyClass {
    companion object {}  // will be called "Companion"
}

fun MyClass.Companion.printCompanion() {
    println("companion")
}


fun main() {
    println("    tim has a ...".trimToUpperCase()) //TIM HAS A ...
    val nullV = null
    println(nullV.trimToUpperCase()) //

    val num1 = NumOp(BigDecimal("1000"))
    num1.mutiply(BigDecimal("2000"))
    println(num1.num) // 2000000

    "test".easyPrint() // test
    BigDecimal("2000").easyPrint() // 2000

    println(listOf("one", "two").lastIndex)

    MyClass.printCompanion()


}