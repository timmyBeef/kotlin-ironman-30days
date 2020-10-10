package com.tim.kotlinspring.config


import com.tim.kotlinspring.security.ADMIN
import com.tim.kotlinspring.security.jwt.JWTConfigurer
import com.tim.kotlinspring.security.jwt.TokenProvider
import org.springframework.context.annotation.Bean
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
class SecurityConfiguration(
        private val tokenProvider: TokenProvider
) : WebSecurityConfigurerAdapter() {

    // 注入密碼要用來加密的方式
    @Bean
    fun passwordEncoder() = BCryptPasswordEncoder()

    // Spring Security 忽略這些 url 不做驗證
    override fun configure(web: WebSecurity?) {
        web!!.ignoring()
                .antMatchers(HttpMethod.OPTIONS, "/**")
                .antMatchers("/app/**/*.{js,html}")
                .antMatchers("/i18n/**")
                .antMatchers("/content/**")
                .antMatchers("/h2-console/**")
                .antMatchers("/swagger-ui/index.html")
                .antMatchers("/test/**")
    }

    @Throws(Exception::class)
    public override fun configure(http: HttpSecurity) {
        http
                .csrf() // 因為是做 token 驗證，不用開啟避免 csrf
                .disable()
                .headers()
                .frameOptions() // 防止 IFrame 式 Clickjacking 攻擊，上方已經許可 "/h2-console/**"(有用到 iframe) 所以可以正常顯示
                .deny()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 無狀態的 session 政策，不使用 HTTPSession
                .and()
                .authorizeRequests()
                .antMatchers("/api/user/register").permitAll() // 註冊時不做認證
                .antMatchers("/api/authenticate").permitAll() // 取 token 時不做認證
                .antMatchers("/api/**").authenticated() // 其他都要做認證
                .antMatchers("/management/**").hasAuthority(ADMIN) // 只有 ADMIN 角色可以看 acutator 的管理 url
                .and()
                .httpBasic()
                .and()
                .apply(securityConfigurerAdapter()) // 其實裡面就是要做 jwt 的 filter, 在 filter 的過程中驗證 token
    }

    private fun securityConfigurerAdapter() = JWTConfigurer(tokenProvider)
}
