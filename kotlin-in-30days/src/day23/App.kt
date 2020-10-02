package day23

fun acceptString(obj: String): String {
    println("acceptString:$obj")
    return obj
}

fun acceptInt(obj: Int): Int {
    println("acceptString:$obj")
    return obj
}

fun acceptAny(obj: Any): Any {
    println("acceptAny:$obj")
    return obj
}

fun <T> acceptT(obj: T): T {
    println("acceptT:$obj")
    return obj
}

fun <T, R> acceptTAndReturnR(obj: T): R {
    return "test" as R
}

class Data<V>(val value: V)

fun <T : Number> sum(num1: T, num2: T): T {
    return num1.toDouble().plus(num2.toDouble()) as T
}

fun <T> appendDot(seq: T): T
        where T : CharSequence, T : Appendable {
    if (!seq.endsWith('.')) {
        seq.append('.')
    }
    return seq
}

fun <T> compareObj(obj1: T, obj2: T): Boolean? {
    return obj1?.equals(obj2)
}

fun <T : Any> compareObj2(obj1: T, obj2: T): Boolean? {
    return obj1.equals(obj2)
}

//fun <T> specailSum(num1: T, num2: T): T
//        where T: Int, T: Double {
//    return num1.toDouble().plus(num2.toDouble()) as T
//}

fun main() {

    val str = acceptString("100")
    println("acceptString output:" + str.toInt().plus(10)) // acceptString output:110

    val int = acceptInt(100)
    println("acceptInt output:" + int.plus(10)) // acceptInt output:110

    val anything = acceptAny("100")
    // 因為 anything 是 Any 型態，所以根本不能用 toInt()
    // println("any output:" + anything.toInt() + 10)
    // println("any output:" + (anything as Int).plus(10)) // Exception
    println("any output:" + (anything as String).toInt().plus(10)) // any output:110

    // call generic
    val t = acceptT("100")
    println("generic output:" + t.toInt().plus(10)) // generic output:110

    val dataLong = Data<Long>(1000L)
    val dataStr = Data<String>("data test")

    println(sum(100, 200))
    println(sum(300.35, 400.55))
    // println(sum("100",400.55)) not ok

}
