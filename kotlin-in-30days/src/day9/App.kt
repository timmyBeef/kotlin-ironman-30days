package day9

import java.math.BigDecimal
import kotlin.math.roundToInt

fun main() {
    val numStr = "3.14"
    val num0 = numStr.toDouble()
    // val num10 = numStr.toInt() // 會發生 NumberFormatException
    val num1 = numStr.toIntOrNull() ?: 0
    println(num0)
    println(num1)

    val numStr2 = "abc"
    val num2 = numStr2.toIntOrNull() ?: 0
    val num3 = numStr2.toBigDecimalOrNull() ?: 0
    println(num2)
    println(num3)

    val x = 10.1
    val y = 5.53
    val result = x - y
    println(result) // 4.569999999999999
    println("%.2f".format(result)) // 4.57
    println(result.roundToInt()) // 5

    println("BigDecimal demo...")
    println(BigDecimal.valueOf(x).minus(BigDecimal.valueOf(y))) // 4.57
    println(BigDecimal.valueOf(x) - BigDecimal.valueOf(y))  // 4.57

    println(BigDecimal.valueOf(x).plus(BigDecimal.valueOf(y))) // 15.63
    println(BigDecimal.valueOf(x) + BigDecimal.valueOf(y)) // 15.63

    println(BigDecimal.valueOf(100.123).compareTo(BigDecimal.ZERO) > 0) // true
    println(BigDecimal.valueOf(100.123) > BigDecimal.ZERO) // true

    println(BigDecimal(x) - BigDecimal(y)) //4.56999999999999939603867460391484200954437255859375

    // bit operator
    println(42.shl(1)) // var43 = 42 << 1;  // 84
    println(42.shr(1)) // var43 = 42 >> 1;  // 21
    println(42 shr 1) // var43 = 42 >> 1;           // 21

    // leetcode 136
    println("singleNumber result:" + singleNumber(intArrayOf(2, 2, 5)))
}

// leetcode 153
fun findMin(nums: IntArray): Int {
    var left = 0
    var right = nums.size - 1

    while (left < right) {
        var mid = (left + right).shr(1)
        if (nums[mid] > nums[right]) {
            left = mid + 1
        } else {
            right = mid
        }
    }
    return nums[left]
}

// leetcode 136
fun singleNumber(nums: IntArray): Int {
    var result = 0;
    nums.forEach {
        result = result.xor(it); //do xor
    }
    return result;
}