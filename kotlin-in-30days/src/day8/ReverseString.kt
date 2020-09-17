package day8

class ReverseString {
    fun reverseString(s: CharArray): Unit {
        if (s.isEmpty()) return
        for (i in 0..s.lastIndex / 2) {
            val temp = s[i]
            s[i] = s[s.lastIndex - i]
            s[s.lastIndex - i] = temp
        }
    }

    fun reverseString2(s: CharArray): Unit {
        var left = 0
        var right = s.size - 1
        while (left < right) {
            val temp = s[left]
            s[left] = s[right]
            s[right] = temp
            left++
            right--
        }
    }
}