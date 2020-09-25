package day16

data class Employee(var name: String, var id: Long)


class test(var name: String, var id: Long) {
    operator fun component1(): String {
        return name
    }
    operator fun component2(): Long {
        return id
    }
}

fun main() {
    val (name, id) = test("tim", 123L)
}

