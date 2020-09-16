package day7

fun main() {

    // 函數可以是回傳值
    println(returnAsLambda())   // () -> kotlin.Int
    println(returnAsLambda()()) // lambda is Closure, result: 101
    println(returnAsLambda()()) // lambda is Closure, result: 101

    val getFromFunFactory = returnAsLambda()
    println(getFromFunFactory()) // lambda is Closure, result: 101
    println(getFromFunFactory()) // lambda is Closure, result: 102

    val getFromAnonymousFunFactory = returnAsAnonymousFun()
    println(getFromAnonymousFunFactory())
    println(getFromAnonymousFunFactory())


    // IIFE
    println("IIFE...")
    val iife = (fun(): () -> Int {
        var num = 100
        return {
            // var num = 100
            num++
            println("lambda is Closure, result: $num")
            num
        }
    })()

    iife() // lambda is Closure, result: 101
    iife() // lambda is Closure, result: 102

// simple way
    val iifeSimple = {
        var num = 100
        {
            // var num = 100
            num++
            println("lambda is Closure, result: $num")
            num
        }
    }()

    iifeSimple()
    iifeSimple()


    fun runLambda(userName: String, showUserStatus: (Int, String) -> String) {
        val id = 83666
        println(showUserStatus(id, userName))
    }

    // 如果今天要呼叫的 function 是個 具名函數, 不是 lambda or 匿名函數
    // function ref: 把 具名函數 轉成 lambda expression
    // use function ref
    fun showUserStatusFun(id: Int, name: String): String {
        println("result is userName: $name, his/her id is $id")
        return "userName: $name, his/her id is $id"
    }
    // runLambda("Tim", showUserStatusFun) -> cant use like this
    runLambda("Tim", ::showUserStatusFun)

    // vararg
    sayHi("hello")
    sayHi("hello", "a", "b", "c")
    val stringArray = arrayOf("a", "b", "c")
    // 這樣是不可行的～！
    // sayHi("hello", stringArray)

    // spread operator
    sayHi("hello", *stringArray)

    runInlineLambda("Tim") { id: Int, name: String ->
        println("result is userName: $name, his/her id is $id")
        "userName: $name, his/her id is $id"
    }

    println("tailrec test....")
    println(fibonacci(3))
    println(fibonacci2(3))
    println(fibonacciByTailrec(3))

}

inline fun runInlineLambda(userName: String, showUserStatus: (Int, String) -> String) {
    val id = 83666
    println(showUserStatus(id, userName))
}

inline fun runPartInlineLambda(
        userName: String,
        showUserStatus: (Int, String) -> String,
        noinline test: () -> String
) {
    val id = 1234
    callTest(test)
    println(showUserStatus(id, userName))
}

fun callTest(test: () -> String) {
    println(test())
}

fun returnAsLambda(): () -> Int {
    var num = 100
    return {
        // var num = 100
        num++
        println("lambda is Closure, result: $num")
        num
    }
}

fun returnAsAnonymousFun(): () -> Int {
    var num = 100
    return fun(): Int {
        // var num = 100
        num++
        println("Anonymous Function is Closure, result: $num")
        return num
    }
}

// 這裏多個 string 傳入 vararg 會變成一個 array, 傳不傳都可以
fun sayHi(greeting: String, vararg lotsGreeting: String) {
    // greeting = "test"
    println(greeting)
    lotsGreeting.forEach { println("lotsGreeting: $it") }
}

fun fibonacci(n: Int): Int {
    if (n < 2) return n
    return fibonacci(n - 1) + fibonacci(n - 2)
}

// 這是錯的！ return 不能有算式, 只能呼叫函數本身
tailrec fun fibonacci2(n: Int): Int {
    if (n < 2) return n
    return fibonacci2(n - 1) + fibonacci2(n - 2)
}

// 改成這樣
tailrec fun fibonacciByTailrec(n: Int, a: Int = 0, b: Int = 1): Int {
    if (n == 0) return a
    if (n == 1) return b
    return fibonacciByTailrec(n - 1, a, a + b)
}

tailrec fun fibonacciByTailrecAndWhen(n: Int, a: Int = 0, b: Int = 1): Int =
        when (n) {
            0 -> a
            1 -> b
            else -> fibonacciByTailrecAndWhen(n - 1, a, a + b)
        }
