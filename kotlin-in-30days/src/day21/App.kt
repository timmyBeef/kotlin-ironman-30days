package day21

import java.io.File


class Person(var name: String, var id: String) {
    fun getResult(): String {
        return "return result!"
    }

    fun sing() {
        println("sing")
    }

    fun jump() {
        println("jump")
    }

    fun getBoolean(): Boolean {
        return true
    }

    override fun toString(): String {
        return "name: $name, id: $id"
    }
}

fun main() {
    val alice = Person("Alice", "123")

    alice.run {
        this.name = "Tim"
        this.jump()
        this.getResult() // 把最後一句的結果回傳, 可以再接著下去 chain
    }.run {
        println(this)
    }

    alice.run {
        println("\n\nrun this + print result")
        name = "Tim"
        jump()
        getResult() // 把最後一句的結果回傳, 所以會是 String , 可以再接著下去 chain
    }.run {
        println(this)
    }

    alice.apply {
        println("\n\napply this + print person")
        name = "Tim"
        jump()
        getResult() // 這樣寫沒有意義， apply 回傳的是本身，也就是 this
    }.run {
        println(this)
    }

    // 設定某物件時，使用 apply，使寫法更簡潔
    val file = File("test.txt")
    file.setReadable(true)
    file.setReadOnly()
    file.setExecutable(true)

    //  use apply
    val file2 = File("test.txt").apply {
        setReadable(true)
        setReadOnly()
        setExecutable(true)
    }


    // 像是 run 的變形
    with(alice) {
        println("\n\nrun this + print result")
        name = "Tim"
        jump()
        getResult() // 把最後一句的結果回傳, 所以會是 String , 可以再接著下去 chain
    }.run {
        println(this)
    }

    //let
    alice.let {
        println("\n\nlet it + print result")
        it.name = "tim"
        it.jump()
        it.getResult() // 把最後一句的結果回傳, 所以會是 String , 可以再接著下去 chain
    }.run {
        println(this)
    }

    // it is a val
    // "Kotlin".let { it = "Java" }

    // 把 it 成自己命名的參數名稱
    alice.let { person ->
        println("\n\nlet it + print result")
        person.name = "tim"
        person.jump()
        person.getResult()
    }



    alice.also {
        println("\n\nalso it + print person")
        it.name = "tim"
        it.jump()
        it.getResult()
    }.run {
        println(this)
    }

    var bytes: ByteArray? = null
    File("test.txt").also {
        println(it.name)
    }.also {
        bytes = it.readBytes()
    }

    val bytes2 = File("test.txt").also {
        println(it.name)
    }.let {
        it.readBytes()
    }


    alice.takeIf {
        it.getBoolean()
    }.run {
        println(this)
    }

    alice.takeIf {
        it.getBoolean()
    }?.run {
        println(this)
    }

    val fileText = File("test.txt")
            .takeIf {
                it.canRead() && it.canWrite()
            }?.readText()

    alice.takeUnless {
        it.getBoolean()
    }?.run {
        println(this)
    }

}
