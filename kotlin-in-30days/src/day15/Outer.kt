package day15

class Outer {
    val outer = "outer property"
    class Nested {
        val nested = " nested property"
        fun print() {
            // println(outer) // 無法存取到外部的 outer
            println(nested)
        }
    }

    inner class Inner {
        val inner = " inner property"
        fun print() {
            println(outer) // 可以存取到外部的 outer
            println(inner)
        }
    }
}

fun main() {
    // nested class
    val nested = Outer.Nested()
    nested.print()

    // inner class
    val outer = Outer()
    val inner = outer.Inner()
    inner.print()
}