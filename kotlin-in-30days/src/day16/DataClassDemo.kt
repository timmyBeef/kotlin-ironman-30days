package day16

import java.math.BigDecimal

data class Employee(var name: String, var id: Long)


class Test(var name: String, var id: Long) {
    operator fun component1(): String {
        return name
    }
    operator fun component2(): Long {
        return id
    }

    override fun toString(): String {
        return "name: $name, id: $id"
    }
}

data class Company(var name: String, var employees: MutableList<Employee>)

data class ObTest(var test: Test, var money: BigDecimal)


fun main() {
    // componentN
    // 使用 data class 不用做 operator fun component1 ～ N 會自動產生
    val (name, id) = Employee("tim", 123L)

    // 一般 class 要自己實作 operator fun component1 ～ N
    val (name2, id2) = Test("tim", 123L)

    // copy() in collection case
    val tim = Employee("tim", 555L)
    val jean = Employee("jean", 666L)

    val company = Company("Google", mutableListOf(tim, jean))
    val subCompany = company.copy(name = "Google youtube")
    company.employees.add(Employee("ann", 777L))

    println(company)
    println(subCompany)

    // copy() in object case
    val o = ObTest(Test("tim",123), BigDecimal("1000"))
    val o2 = o.copy()
    o2.test = Test("ann",555)
    o2.money = BigDecimal(500)
    println(o2)
    println(o)

}

