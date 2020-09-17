package day8

fun main() {
    val str = "Tim's string"
    val index = str.indexOf('\'')

    println(str.substring(0 until index)) // Tim
    println(str.substring(0)) // Tim's string
    println(str.substring(0, index)) // Tim

    val names = "tim, jerry, anna"

    val data = names.split(',') // ["tim", "jerry", "anna"]
//    val tim = data[0]   // "tim"
//    val jerry = data[1] // "jerry"
//    val anna = data[2]  //"anna"

    val (tim, jerry, anna) = names.split(',')
    // 字串比較

    val (tim2, _, anna2) = names.split(',')


    val s: String? = "kotlin"
    // isEmpty, isNotEmpty 要有 ?, isNullOrEmpty 不需要
    println(s?.isEmpty()) // length == 0
    println(s?.isNotEmpty())
    println(s.isNullOrEmpty())

    // isBlank, isNotBlank 要有 ?, isNullOrBlank 不需要
    println(s?.isBlank()) //  length == 0 或有空白
    println(s?.isNotBlank())
    println(s.isNullOrBlank())

    println(s + " very good")
    println(s.plus(" very good"))
    println(s.plus(" very good").plus("haha"))
    println("$s very good")
    // var19 = s + " very good"; 只有一次的字串串接, 還是會只用 +

    /*
        跟在 Java 一樣
        String 是 immutable 的,
        串接字串用 + 或 plus 都會造成新的記憶體不斷的被創造出來,
        使用 StringBuilder 比較好
     */
    val builder = StringBuilder()
    builder.append("Aloha")
            .append(" ")
            .append("Tim")

    val a = "Aloha"
    val b = " "
    val c = "Tim"
    val d = "$a$b$c"
    // 會幫我們轉成 (new StringBuilder()).append(a).append(b).append(c).toString();
}