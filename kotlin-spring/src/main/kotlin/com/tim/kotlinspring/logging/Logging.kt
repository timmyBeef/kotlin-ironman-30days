package com.tim.kotlinspring.logging

import org.slf4j.LoggerFactory.getLogger

interface Logging {

    fun <T : Logging> T.log() = getLogger(javaClass)
}