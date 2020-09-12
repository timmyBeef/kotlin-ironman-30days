package day3

/*
    day3: variables
 */
const val FILE_PATH: String = "/test"

fun main() {
    val name = "Tim" // read-only variable
    // name = "Alex"
    println("Hello world! $name")

    var name2 = "Tim" // variable
    name2 = "Alex"
    println("Hello world! $name2")

    val count: Int = 123
    var number: Long = 1234

    // const val MAX_COUNT: Long = 5000L

    var name3: String? = "Tim"
    name3 = null

}