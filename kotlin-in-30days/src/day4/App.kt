package day4

import java.math.BigDecimal

/*
    day4: variables & control flow
 */
fun main() {
    var name: String? = null
    println(name?.toUpperCase()) // null
    // println(name!!.toUpperCase()) // throw kotlin.KotlinNullPointerException

    // Elvis operator
    val name2: String = name ?: "default name" // default name
    // val name3: String = (name != null) ? name : "default name"
    println(name2)

    val name4 = "tim"
    val name5 = "TIM"
    println(name4.toUpperCase() == name5) // true, 內容相等
    println(name4.toUpperCase() === name5) // false, 物件指向的記憶體位置不同

    val name6 = "tim"
    val name7 = "tim"
    println(name6 == name7) // true, 內容相等
    println(name6 === name7) // true, 物件指向的記憶體位置相同, 在 java 中, 內容一樣的字串創立會共用 string pool

    // if else
    val address: String? = null
    if (address != null) {
        println("address is $address") // address is null
    } else {
        println("address is null")
    }

    // as expression
    val num1 = 10
    val num2 = 12
    val max = if (num1 > num2) num1 else num2

    val max2 = if (num1 > num2) {
        print("max is num1")
        num1
    } else {
        print("max is num2")
        num2
    }

    whenFun(98) // it's between 1 to 99
    whenFun("c") // in some list
    whenFun(1000) // it's Integer
    whenFun(BigDecimal.ONE) //it's BigDecimal

    // for example
    val numList = listOf(1, 2, 3, 4, 5, 6)
    for (num in numList) { // for in
        println(num)
    }
    // forEach
    numList.forEach { num -> println(num) }
    numList.forEach { println(it) }

    // while
    val end = 5
    var i = 0
    while (i < end) {
        println(i)
        i++
    }

    // do while
    var j = 0
    do {
        j++
        println("do while $j")
    } while (j < end)

    // repeat
    repeat(5) { println("repeat $it") }

}

fun whenFun(num: Any) {
    val result = when (num) {
        0 -> "it's zero"
        in 1..99 -> "it's between 1 to 99" // 使用 range 來比對(1~99)
        100, 101 -> "it's 100 or 101" // 100 或 101
        in listOf("a", "b", "c") -> "in some list" // 確認 num 是否在這 list 裡面
        !in setOf("a", "b", "c") -> "not in this set" // 確認 num 是否 不在這 set 裡面
        is Int -> "it's Integer" // 型態是否是 Int
        is String -> "it's String" // 型態是否是 String
        is BigDecimal -> "it's BigDecimal" // 型態是否是 BigDecimal
        !is Double -> "it's not Double" // 型態不是 Double
        else -> "not match" // 對應不到時預設值
    }
    println(result)
}
