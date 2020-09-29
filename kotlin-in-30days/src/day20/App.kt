package day20

fun main() {
    // set
    val intSet = setOf(3, 1, 2, 3)
    println(intSet) // [3, 1, 2]

    val muList = mutableListOf("tim", "andy", "ann")
    val set = muList.toSet()
    println(set) // [tim, andy, ann]

    // mutableSet
    val intMuSet = mutableSetOf(3, 1, 2, 3)
    println(intMuSet) // [3, 1, 2]

    val muSet = muList.toMutableSet()
    println(muSet) // [tim, andy, ann]

    // set沒有這種寫法, 要用 elementAt, set 沒有 index 排序, 所以沒有[]
    // muSet[0]
    // muSet.get(0)
    muSet.elementAt(0) // "tim"
    println(muSet.elementAtOrElse(4) { "no value" })
    println(muSet.elementAtOrNull(5) ?: "no value")

    println(muSet.size)
    // 在 set 最後面加入
    muSet.add("Bob")

    // 在 set 最後面加入一堆 data
    muSet.addAll(listOf("a", "b", "c"))

    // remove 某資料
    muSet.remove("tim")
    // 清除所有
    muSet.clear()

    // hashSet
    val hashSet = hashSetOf("b", "a", "c")
    println(hashSet) // [a, b, c]

    // linkedHashSet
    val linkedSet = linkedSetOf("b", "a", "c")
    println(linkedSet) // [b, a, c]

    // sortedSet
    println("sortedSet...")
    val sortedSet = sortedSetOf("1234", "12", "555555")
    println(sortedSet) // [12, 1234, 555555]

    // emptySet
    emptySet<String>()

    // for
    val sMuSet = mutableSetOf("e", "d", "c", "b")
    println("for demo...")
    for (data in sMuSet) {
        println(data)
    }

    for (idx in sMuSet.indices) {
        println(sMuSet.elementAt(idx))
    }

    for (d in sMuSet.withIndex()) {
        println("idx: ${d.index}, value: ${d.value}")
    }

    sMuSet.forEach {
        println("each name: $it")
    }

    sMuSet.forEachIndexed { index, name ->
        println("each name: #${index} - $name")
    }
    println("for demo...end")


    //val is not really immutable
    val x = mutableSetOf(4, 5, 6, 7)
    val y = mutableSetOf(4, 5, 6, 7)
    println("val immutable test before:" + (x == y)) // true
    x.add(8)
    println("val immutable test after:" + (x == y)) // false

    val listMu = listOf(1, 2, 3)
    (listMu as MutableList)[1] = 100
    listMu.toMutableList().removeAt(1)
    println(listMu)

    val setMu = setOf(1, 2, 3)
    (setMu as MutableSet).add(100)
    setMu.toMutableSet().remove(100)
    println(setMu)

    println(listMu.toSet())
    println(setMu.toList())
}
