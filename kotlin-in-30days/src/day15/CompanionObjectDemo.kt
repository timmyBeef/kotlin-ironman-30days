package day15

class Entity private constructor(val someData: String) {
    companion object Factory{
        fun create(): Entity {
            return Entity("someData")
        }
    }
}

class SerialNoGeneratorK {

    companion object {
        var count = 0
        fun gen(): Int {
            count++
            println(count)
            return count
        }
    }
}

fun main() {
    SerialNoGeneratorK.gen()
    SerialNoGeneratorK.gen()
    SerialNoGeneratorK.gen()
    SerialNoGeneratorK.gen()

    val entity = Entity.Factory.create()
    println(entity)
    val entity2 = Entity.create()
    println(entity2)

}