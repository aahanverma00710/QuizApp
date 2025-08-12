package com.avcoding

import com.avcoding.presentation.config.configureLogging
import com.avcoding.presentation.config.configureRouting
import com.avcoding.presentation.config.configureSerialization
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureLogging()
    configureRouting()
    configureSerialization()
}
