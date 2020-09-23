package day14

abstract class ViewGroup(width: Int, height: Int) : View(width, height) {

    override val size = width * height
    override val color = "white"
    override fun click() {
        println("do clicking...")
    }

    abstract override fun isHidden(): Boolean

    // override fun test() // 不能被覆寫，因為不是 open
}