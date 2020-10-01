package day22

import java.lang.RuntimeException

fun main() {
    // to 省略小數點和括號的寫法
    val map = mapOf("A" to 10, "B" to 20, "C" to 30) // {A=10, B=20, C=30}

    val mapP = mapOf(Pair("A", 10), Pair("B", 20), Pair("C", 30)) // {A=10, B=20, C=30}
    println(map)
    println(mapP)

    val muMap = mutableMapOf("A" to 10, "B" to 20, "C" to 30)


//    val muMap = map.toMutableMap()
    println(muMap["A"])
    println(muMap.get("A"))
    // println(muMap.getValue("D")) getValue() key 不存在時會拋出 NoSuchElementException
    println(muMap.getOrElse("E") { "no value" })
    println(muMap.getOrDefault("E", 50))

    muMap += "D" to 40
    muMap["F"] = 100
    muMap.put("A", 5)
    println("after add or update muMap: $muMap")

    muMap.putIfAbsent("A", 100)

    muMap.putAll(listOf("F" to 5, "G" to 6))
    muMap.putAll(mapOf(Pair("A", 10), Pair("B", 20)))

    println("getOrPut:" + muMap.getOrPut("G") { 200 })

    println(muMap)

    muMap.remove("G")
    muMap -= "D"
    println(muMap)

    muMap.forEach {
        println(it.key + "," + it.value)
    }
    muMap.forEach { (key, value) -> println("$key , $value") }

    for (entry in muMap) {
        println(entry.key + "," + entry.value)
    }

    // deconstruct
    for ((k, v) in muMap) {
        println("$k,$v")
    }

    hashMapOf("A" to 10, "B" to 20, "C" to 30)

    linkedMapOf("A" to 10, "B" to 20, "C" to 30)

    sortedMapOf("A" to 10, "B" to 20, "C" to 30)

    emptyMap<String, Int>()

    // java
    println("compute:" + muMap.compute("H") { _: String, _: Int? -> 200 })
    println("computeIfAbsent:" + muMap.computeIfAbsent("J") { 100 })

}

//     var set = mutableSetOf()

fun permuteUnique(nums: IntArray): List<List<Int>> {
    val results = mutableListOf<List<Int>>()

    if (nums.isEmpty()) {
        return results
    }
    if (nums.size == 1) {
        return results.apply {
            add(mutableListOf(nums[0]))
        }
    }

    val ints = IntArray(nums.size - 1)
    System.arraycopy(nums, 0, ints, 0, nums.size - 1)

    val set = mutableSetOf<List<Int>>()

    for (list in permuteUnique(ints)) {
        for (i in 0..list.size) {
            val tmp = mutableListOf<Int>()
            tmp.addAll(list)
            tmp.add(i, nums[nums.size - 1])
            set.add(tmp)
        }
    }

    return results.apply { addAll(set) }
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int, Int>()
    nums.forEachIndexed { idx, value ->
        if (map.containsKey(target - value)) {
            return intArrayOf(map.getValue(target - value), idx)
        }
        map.put(value, idx)
    }
    throw RuntimeException("not found")
}

fun twoSumSimple(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int, Int>()
    nums.forEachIndexed { idx, value ->
        map[target - value]?.let { return intArrayOf(it, idx) }
        map[value] = idx
    }
    throw RuntimeException("not found")
}