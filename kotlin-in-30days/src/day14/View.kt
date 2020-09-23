package day14

abstract class View(val width: Int, val height: Int) {
    // abstract: 只有宣告，沒有實作, 子類別都要複寫這些方法
    abstract val size: Int
    abstract fun draw()
    abstract fun click()

//    abstract fun draw2() { // abstract 不能有實做 body
//
//    }

    // 有實做的, 有 open 可以 override
    open val color = "dark"
    open fun isHidden(): Boolean {
        return false
    }

    fun test() {
        println("test")
    }
}

