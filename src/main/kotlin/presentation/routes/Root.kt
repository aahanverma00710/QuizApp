package com.avcoding.presentation.routes

import io.ktor.server.response.respondText
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.root(){
    get(path = "/" ){
        call.respondText(text = "Welcome to My quiz api!!!!!")
    }
    get(path = "/Hello" ){
        call.respondText(text = "Hello Ktor")
    }
    get(path = "/quiz" ){
        call.respondText(text = "What is my name!!!!!")
    }
}