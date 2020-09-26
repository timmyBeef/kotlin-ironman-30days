package day17

enum class PaymentRtnCode(var type: String, var code: String) {
    RC2("token 錯誤", "2"),
    RC1("系統維護中", "1"),
    RCN4("無此帳戶", "-4"),
    C0("有未繳費用", "0");

    companion object {
        fun getType(code: String): String {
            for (b in values()) {
                if (b.code == code) {
                    return b.type
                }
            }
            return "未知的原因"
        }
    }
}

data class RtnCode(var type: String, var code: String)

enum class PaymentRtnCode2(private val rtnCode: RtnCode) {
    RC2(RtnCode("token 錯誤", "2")),
    RC1(RtnCode("系統維護中", "1")),
    RCN4(RtnCode("無此帳戶", "-4")),
    C0(RtnCode("有未繳費用", "0"));

    companion object {
        fun getType(code: String): String {
            for (b in PaymentRtnCode.values()) {
                if (b.code == code) {
                    return b.type
                }
            }
            return "未知的原因"
        }
    }
}