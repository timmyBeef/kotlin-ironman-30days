package day14

class App(width: Int, height: Int) : ViewGroup(width, height), OnBlurListener, OnClickListener {
    override fun isHidden(): Boolean {
        return false
    }

    override fun draw() {
        println("drawing....")
    }

    fun printSize() {
        println("size is $size")
    }

    override fun onBlur() {
        println("app onBlur...")
    }

    override fun onClick() {
        println("app onClick...")
    }

    override fun onClick3() {
        println("app onClick3...")
    }

    override val isClick = true
}

fun main() {
    val app = App(100, 200)
    app.draw()
    app.printSize()
    app.click()
    app.test() // test
    app.onClick() // app onClick...
    app.onClick2() // 呼叫介面裡本來就有實作的內容 OnClickListener click
    app.onClick3() // app onClick3...
    app.onBlur() // app onBlur...
    app.isClick2 = true // true 印出了 介面裡定義的 set println
}