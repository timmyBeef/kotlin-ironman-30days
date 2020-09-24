package day15

open class BaseClass {
    open fun getParameter(): String {
        return "parameters"
    }
}

open class Generator {
    fun printGeneratorNo(no: Int) {
        val parameter = object : BaseClass() {
            override fun getParameter() = "Generator's parameter"
        }

        println("parameter: ${parameter.getParameter()}")
        println("no: $no")
    }
}

object SerialNoGenerator : Generator() {
    var count = 0

    init {
        // do init...
    }

    fun gen(): Int {
        count++
        printGeneratorNo(count)
        return count
    }
}

fun main() {
    SerialNoGenerator.gen()
    SerialNoGenerator.gen()
    SerialNoGenerator.gen()
    SerialNoGenerator.gen()
}