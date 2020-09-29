package day18

class PersonT(val name: String, val no: Int)

fun main() {
    val aryOfNulls = arrayOfNulls<Int>(3) // new Integer[3];
    val aryOfInt = arrayOf<Int>(1, 2, 3) // new Integer[]{1, 2, 3};
    val aryOfBoolean = arrayOf<Boolean>(true, false) // new Boolean[]{true, false};
    val aryOfLong = arrayOf<Long>(555L, 666L) // new Long[]{555L, 666L};
    val aryOfPersonT = arrayOf<PersonT>(PersonT("tim", 123)) // new PersonT("tim", 123);

    val manyTypeAry = arrayOf(100, true, "test") // Any type, new Object[]{100, true, "test"};

    val arrayLambda = Array<Int>(5) { // it 會是 index
        it
    }
    arrayLambda.forEach { println(it) } // 0 1 2 3 4

    // 基礎型態 primitive type array
    intArrayOf()
    longArrayOf()
    shortArrayOf()
    byteArrayOf()
    doubleArrayOf()
    floatArrayOf()
    booleanArrayOf()
    charArrayOf()

    // 基礎 array 沒有唯獨, 可變
    val intAry0 = IntArray(5) // new int[5];
    val intAry1 = intArrayOf() // int[] intAry = new int[0];
    val intAry2 = intArrayOf(1, 3, 4) // int[] var43 = new int[]{1, 3, 4};
    val charAry = charArrayOf('a', 'd', 'e') // new char[]{'a', 'd', 'e'};

    val arySize = charAry.size // 3
    charAry.isEmpty()
    charAry.isNotEmpty()
    charAry.last() // return the last element
    charAry.lastIndex
    charAry.last { it == 'e' }
    charAry.all { it == 'e' } // Returns `true` if all elements match the given
    charAry.any() // return true if array has at leat one element
    charAry.any { it == 'a' } // Returns `true` if at least one element matches the given

    // get
    println(charAry[1]) // 'd'
    println(charAry.get(2)) // 'e'

    // set
    charAry[2] = 'F'
    println(charAry)
    charAry.set(2, 'f')
    println(charAry)

    // charAry[3] // java.lang.ArrayIndexOutOfBoundsException: 3

    // iterate
    val dataAry = arrayOf("Tim", "Beef", "Jean")
    for (d in dataAry) {
        println(d)
    }

    for (idx in dataAry.indices) { // dataAry.indices 是 array 的 index
        println(dataAry[idx])
    }

    for (d in dataAry.withIndex()) { // dataAry.indices 是 array 的 index
        println("idx: ${d.index}, value: ${d.value}")
    }

//    dataAry.forEach {  }
//    dataAry.forEachIndexed()

    // multi dimensional array
    val twoDAry = arrayOf(
            arrayOf("0,0", "0,1", "0,2"),
            arrayOf("1,0", "1,1", "1,2"),
            arrayOf("2,0", "2,1", "2,2"),
            arrayOf("3,0", "3,1", "3,2")
    )
    for (rowData in twoDAry.withIndex()) {
        for (colData in rowData.value.withIndex()) {
            println("twoDAry index:${rowData.index},${colData.index}, value is ${colData.value}")
        }
    }
}