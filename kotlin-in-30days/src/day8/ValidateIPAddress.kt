package day8

class ValidateIPAddress {
    fun validIPAddress(IP: String): String {
        return try {
            when {
                IP.count { it == '.' } == 3 -> validateIPv4(IP)
                IP.count { it == ':' } == 7 -> validateIPv6(IP)
                else -> "Neither"
            }
        } catch (e: Exception) {
            "Neither"
        }
    }

    // it != i.toString() 處理一些特殊的 test case, 像是 01.01.01.01
    private fun validateIPv4(IP: String): String {
        IP.split('.').forEach {
            val i = it.toInt()
            if (i !in 0..255 || it != i.toString())
                return "Neither"
        }
        return "IPv4"
    }

    private fun validateIPv6(IP: String): String {
        IP.split(':').forEach {
            if (it.length > 4 || !it.contains(Regex("^[0-9A-Fa-f]+\$"))) {
                return "Neither"
            }
        }
        return "IPv6"
    }
}