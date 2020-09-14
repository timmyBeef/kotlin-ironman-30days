package day5

/*
    day 5: function
 */
fun main() {
    callSum()

    overload()  // overloading
    overload(1)  // overloading num: 1
    overload(2, false) // overloading num: 2, is true: false
    overload(isTrue = true, num = 10) // overloading num: 10, is true: true
}

// default values
fun sum(a: Int, b: Int, c: Int = 10) = a + b + c

fun callSum() {
    println(sum(1, 2, 3)) // 6
    println(sum(1, 2)) // 13
    println(sum(b = 2, c = 1, a = 5)) // 8
}

fun overload() {
    println("overloading")
}
fun overload(num: Int) {
    println("overloading num: $num")
}
fun overload(num: Int, isTrue: Boolean) {
    println("overloading num: $num, is true: $isTrue")
}

fun todoTest() {
    TODO("this is todo")
    println("todo")
}