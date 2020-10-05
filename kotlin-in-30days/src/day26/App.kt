package day26

fun main() {
    val newList = listOf(1, 2, 3, 4, 5).map { it * 10 }
    println(newList) // [10, 20, 30, 40, 50]

    val newStrList = listOf(1, 2, 3, 4, 5).map<Int, String> { "value $it" }
    println(newStrList) // [value 1, value 2, value 3, value 4, value 5]

    val data = listOf(listOf(1, 2, 3, 4, 5), listOf(100, 101, 102, 103, 104))
    val flatData = data.flatten()
    println("data.flatten$flatData")
    // data.flatten[1, 2, 3, 4, 5, 100, 101, 102, 103, 104]

    val flatData2 = data.flatMap { it.map { it * 10 } }
    println("data.flatMap *10:$flatData2")
    // data.flatMap *10:[10, 20, 30, 40, 50, 1000, 1010, 1020, 1030, 1040]

    val filterResult = listOf(1, 2, 3, 4, 5, 6).filter { it % 2 == 0 }
    println("filterResult:$filterResult")
    // filterResult:[2, 4, 6]

    val numbers = listOf("one", "two", "three", "four")
    println(numbers.any { it.endsWith("e") }) // true
    println(numbers.none { it.endsWith("a") }) // true
    println(numbers.all { it.endsWith("e") }) // false

    // 質數： 不被 1 或 本身除盡的數，以 7 為例子，就是不被 1 或 本身除盡的數
    // 所以如果 7 % (2~6) == 0 => 不是質數
    val nums = listOf(7, 4, 8, 4, 3)
    val primes = nums.filter { num ->
        (2 until num).map {
            num % it
        }.none { it == 0 } // Returns `true` if no elements match the given [predicate].
    }
    println("質數: $primes")


    val partitions = listOf(1, 2, 3, 4, 5, 6).partition { it % 2 == 0 }
    println("partitions: $partitions")
    //partitions: ([2, 4, 6], [1, 3, 5])

    val z1 = listOf(1, 2, 3, 4, 5, 6)
    val z2 = listOf(10, 20, 30)
    val zipResult: List<Pair<Int, Int>> = z1.zip(z2)
    println("zipResult: $zipResult")
    //zipResult: [(1, 10), (2, 20), (3, 30)]

    val reducedValue = listOf(1, 2, 3, 4).reduce { acc, num ->
        println("reduced value: acc:$acc, num:$num")
        acc + num
    }
    println("reducedValue final result: $reducedValue \n\n")
    /*
        reduced value: acc:1, num:2
        reduced value: acc:3, num:3
        reduced value: acc:6, num:4
        reducedValue final result: 10
     */

    val reducedValueRight = listOf(1, 2, 3, 4).reduceRight { num, acc ->
        println("reduced value from Right: acc:$acc, num:$num")
        acc + num
    }
    println("reducedValue from Right final result: $reducedValueRight \n\n")
    /*
        reduced value from Right: acc:4, num:3
        reduced value from Right: acc:7, num:2
        reduced value from Right: acc:9, num:1
        reducedValue from Right final result: 10
     */

    val foldedValue = listOf(1, 2, 3, 4).fold(100) { acc, num ->
        println("accumulated value: acc:$acc, num:$num")
        acc + num
    }
    println("foldedValue final result: $foldedValue \n\n")
    /*
        accumulated value: acc:100, num:1
        accumulated value: acc:101, num:2
        accumulated value: acc:103, num:3
        accumulated value: acc:106, num:4
        foldedValue final result: 110
     */

    val foldedValueRight = listOf(1, 2, 3, 4).foldRight(100) { num, acc ->
        println("accumulated value from Right: acc:$acc, num:$num")
        acc + num
    }
    println("foldedValue final from Right result: $foldedValueRight \n\n")
    /*
        accumulated value from Right: acc:100, num:4
        accumulated value from Right: acc:104, num:3
        accumulated value from Right: acc:107, num:2
        accumulated value from Right: acc:109, num:1
        foldedValue final from Right result: 110
     */
}