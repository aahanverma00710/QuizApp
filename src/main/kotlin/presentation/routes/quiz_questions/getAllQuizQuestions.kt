package com.avcoding.presentation.routes.quiz_questions

import com.avcoding.domain.repo.QuizQuestionRepo
import io.ktor.http.HttpStatusCode
import io.ktor.server.response.respond
import io.ktor.server.response.respondText
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.getAllQuizQuestions(
    repo:QuizQuestionRepo
) {
    get("/quiz/questions") {
        val topicCode = call.queryParameters["topicCode"]?.toIntOrNull()
        val limit = call.queryParameters["limit"]?.toIntOrNull()
        val filterList = repo.getAllQuestions(topicCode,limit)
        if (filterList.isNotEmpty()){
            call.respond(message = filterList,
                status = HttpStatusCode.OK)
        }else{
            call.respond(message = "Not found",
                status = HttpStatusCode.NotFound)
        }

    }
}