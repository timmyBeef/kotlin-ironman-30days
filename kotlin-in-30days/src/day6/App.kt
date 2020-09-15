package day6

fun main() {


    // Anonymous functions
    fun(x: Int, y: Int): Int = x + y

    fun(x: Int, y: Int): Int {
        return x + y
    }

    // lambda expression


    val sum: (x: Int, y: Int) -> Int = { x, y ->
        x + y
    }
    val sum2 = { x: Int, y: Int ->
        x + y
    }
    { x: Int, y: Int ->
        x + y
    }(1, 3)

    val yearFunction = fun(): String {
        val year = 2020
        return "it's $year "
    }

    val yearFunction2 = fun() {
        val year = 2020
        "it's $year "
    }

    val yearFunction3: () -> String = {
        val year = 2020
        "it's $year "
    }

    val yearFunction4 = {
        val year = 2020
        "it's $year "
    }

    // single fun
    fun(): String {
        val year = 2020
        return "it's $year "
    }
    fun() {
        val year = 2020
        "it's $year "
    }

//    () -> String = { // it's wrong
//        val year = 2020
//        "it's $year "
//    }

    {
        val year = 2020
        "it's $year "
    }

    // IIFE (Immediately-Invoked Function Expression), 立即執行函數
    // 結果: it's 2020
    println(
            {
                val year = 2020
                "it's $year "
            }()
    )

    val yearFunParameter: (year: Int) -> String = { year ->
        println("yearFunParameter2:")
        "it's $year "
    }
    val yearFunParameter2: (year: Int) -> String = {
        "it's $it "
    }

    val yearFunParameter3 = { year: Int ->
        "it's $year "
    }

    val multiParameterFun: (Long, String) -> String = { id, name ->
        println("multiParameterFun: $id, $name")
        "name is $name, id is $id"
    }

    val multiParameterFunSimple = { id: Long, name: String ->
        println("multiParameterFun: $id, $name")
        "name is $name, id is $id"
    }

    // ex1: parameter is function
    val countFunction = { char: Char -> char == 'd' }
    "I don't like it".count(countFunction) //1
    "I don't like it".count({ char -> char == 'd' })
    "I don't like it".count({ it == 'd' })
    "I don't like it".count() { it == 'd' }
    "I don't like it".count { it == 'd' }

    // "I don't like it".count { it == 'd' } 的內容實作
    fun countImpl(): Int {
        var count = 0
        for (element in "I don't like it") {
            if (element == 'd') {
                ++count
            }
        }
        return count
    }
    println("countImpl():" + countImpl())

    // ex2: parameter is function
    val showUserStatus = { id: Int, name: String ->
        println("result is userName: $name, his/her id is $id")
        "userName: $name, his/her id is $id"
    }
    runLambda("Tim", showUserStatus)


    // 如果 lambda parameter 在最後面, 能寫成這樣
    runLambda("Tim") { id, name ->
        println("result is userName: $name, his/her id is $id")
        "userName: $name, his/her id is $id"
    }

}

fun runLambda(userName: String, showUserStatus: (Int, String) -> String) {
    val id = 83666
    println(showUserStatus(id, userName))
}

fun returnInt(): Int {
    val num = 100
    return num
}





