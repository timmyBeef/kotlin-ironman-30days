package com.tim.kotlinspring

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinSpringApplication

//fun main(args: Array<String>) {
//	runApplication<KotlinSpringApplication>(*args)
//}

fun main(args: Array<String>) {
	runApplication<KotlinSpringApplication>(*args) {
		setBannerMode(Banner.Mode.OFF)
	}
}
