package day14

interface OnClickListener {
    val isClick: Boolean

    // var isClick3 = false  // 不能給初值, 要用 get
    var isClick2: Boolean
    get() = false
    set(value) {
        println(value)
    }

    fun onClick()

    fun onClick2() {
        println("OnClickListener click")
    }

    fun onClick3() {
        println("OnClickListener click")
    }
}