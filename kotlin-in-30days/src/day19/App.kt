package day19

import java.util.*
import kotlin.collections.ArrayList

fun main() {

// val list:List<String> = listOf("tim", "andy", "ann")
    val list = listOf("tim", "andy", null)
    // list[2] = "jean" // 不行！

    var list2 = listOf("tim", "andy", "ann")
    list2 = listOf("1", "2", "3")

    val listNotNulls = listOfNotNull("tim", "andy", "ann")
    val its = List(5) {
        'a' + it
    } // [a, b, c, d, e]
    println(its)

    val its2 = List(5) {
        "t$it"
    } // [t0, t1, t2, t3, t4]
    println(its2)


    println(list[2]) // ann
    println(list.get(2)) // ann
// println(list[3]) // Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 3
    println(list.getOrElse(3) { "no value" }) // no value
    println(list.getOrNull(3) ?: "no value") // no value

    // tim exists
    if (list.contains("tim")) {
        println("tim exists")
    } else {
        println("tim doesn't exist")
    }

    // one person doesn't exist
    if (list.containsAll(listOf("tim", "jim"))) {
        println("tim, jim exists")
    } else {
        println("one person doesn't exist")
    }

    // mutableListOf

    val muList = mutableListOf("tim", "andy", "ann")
    println(muList.get(0))
    println(muList[0])

    muList.add("Max")
    muList.remove("tim")
    muList.add(0, "tim")
    muList.addAll(listOf("student1", "student2"))
    muList.set(0, "timfix")
    muList[0] = "tim fix again"

    // 移除 "student"
    muList.removeIf { it.contains("student") }
    println(muList)

    val itsMu = MutableList(5) {
        'a' + it
    } // [a, b, c, d, e]
    println(itsMu)

    for (idx in muList.indices) {
        println(muList[idx])
    }

    for (d in muList.withIndex()) {
        println("idx: ${d.index}, value: ${d.value}")
    }

    muList.forEach {
        println("each name: $it")
    }

    muList.forEachIndexed { index, name ->
        println("each name: #${index} - $name")
    }

    val (num1, _, num3) = arrayOf<Int>(1, 2, 3) // new Integer[]{1, 2, 3};

    val (num01, _, num03) = intArrayOf(1, 2, 3) // new int[]{1, 2, 3};

    val (name01, _, name02) = list
    println("$name01 and $name02")

    val (name1, _, name2) = muList
    println("$name1 and $name2")

    emptyArray<Int>()
    emptyList<String>()

    // arrayList
    val aryList = arrayListOf(1, 2, 3) // java ArrayList, ArrayList<E> = java.util.ArrayList<E>
    // 一個空的 ArrayList
    var result = ArrayList<Int>()
    var result2 = LinkedList<Int>()

    // sort
    println("sortedDescending...")
    println(listOf("b", "a", "c").sortedDescending()) // [c, b, a]  降序

    println("sortedBy...")
    println(listOf("b", "a", "c").sortedBy { it }) // [a, b, c]  升序

    println("distinct...")
    println(listOf("name1", "name2", "name1").distinct())
}

fun returnEmpty(): List<String> {
    val result: List<String>? = null
    if (result != null) return result
    return emptyList()
}

