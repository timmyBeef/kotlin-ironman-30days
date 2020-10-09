package com.tim.kotlinspring.security.jwt

import com.tim.kotlinspring.logging.Logging
import io.jsonwebtoken.JwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import java.nio.charset.StandardCharsets
import java.security.Key
import java.util.Date
import javax.annotation.PostConstruct
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.stereotype.Component

private const val AUTHORITIES_KEY = "auth"

@Component
class TokenProvider() : Logging {

    // 定義在設定檔的 secret
    @Value("\${demo.jwt.base64Secret}")
    private val base64Secret: String? = null

    // 定義在設定檔的 token 有效時間
    @Value("\${demo.jwt.expiresSecond}")
    private val expiresSecond: Long = 0

    private var key: Key? = null

    private var tokenValidityInMilliseconds: Long = 0

    // 在 TokenProvider Bean 所有必要的屬性設定完成後要做這些初始化
    // secret 是 BASE64 編碼的 要解開
    @PostConstruct
    fun init() {
        val keyBytes: ByteArray
        log().info("base64Secret is:$base64Secret")

        val base64Secret = base64Secret ?: throw RuntimeException("secret is null")
        keyBytes = Decoders.BASE64.decode(base64Secret)

        this.key = Keys.hmacShaKeyFor(keyBytes)
        this.tokenValidityInMilliseconds = expiresSecond

    }

    // 使用 jjwt lib 產生 token
    fun createToken(authentication: Authentication): String {
        val authorities = authentication.authorities.asSequence()
                .map { it.authority }
                .joinToString(separator = ",")

        val now = Date().time
        val validity = Date(now + this.tokenValidityInMilliseconds)

        return Jwts.builder()
                .setSubject(authentication.name)
                .claim(AUTHORITIES_KEY, authorities)
                .signWith(key, SignatureAlgorithm.HS512)
                .setExpiration(validity)
                .compact()
    }

    fun getAuthentication(token: String): Authentication {
        val claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .body

        val authorities = claims[AUTHORITIES_KEY].toString().splitToSequence(",")
                .mapTo(mutableListOf()) { SimpleGrantedAuthority(it) }

        val principal = User(claims.subject, "", authorities)

        return UsernamePasswordAuthenticationToken(principal, token, authorities)
    }

    fun validateToken(authToken: String): Boolean {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(authToken)

            return true
        } catch (e: JwtException) {
            log().info("Invalid JWT token.")
            log().trace("Invalid JWT token trace. $e")
        } catch (e: IllegalArgumentException) {
            log().info("Invalid JWT token.")
            log().trace("Invalid JWT token trace. $e")
        }

        return false
    }
}
